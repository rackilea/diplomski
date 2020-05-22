static List<Frame<BasicValue>> analyze(
    String ownerClass, MethodNode methodNode) throws AnalyzerException {

  final BasicValue ownerType=toBasicValue(null, ownerClass);
  BasicInterpreter interpreter = new BasicInterpreter() {
    @Override
    public BasicValue newValue(Type type) {
      return type==null || isPrimitive(type.getSort())? super.newValue(type):
             type.equals(ownerType.getType())? ownerType: new BasicValue(type);
    }
    private boolean isPrimitive(int sort) {
      return sort!=Type.OBJECT&&sort!=Type.ARRAY;
    }
  };
  List<Frame<BasicValue>> frames=new ArrayList<>();

  Frame<BasicValue> current = methodEntryFrame(methodNode, ownerType, interpreter);

  for(int ix=0, num=methodNode.instructions.size(); ix<num; ix++) {

    AbstractInsnNode i=methodNode.instructions.get(ix);

    if(i.getType() == AbstractInsnNode.FRAME) {
      current = extractFrame(methodNode, ownerType, (FrameNode)i);
      continue;
    } else if(i.getOpcode()<0) continue;//pseudo instruction node
    frames.add(new Frame<>(current));
    current.execute(i, interpreter);
  }

  return frames;
}

private static Frame<BasicValue> extractFrame(
    MethodNode methodNode, BasicValue ownerType, FrameNode fn) {

  Frame<BasicValue> current = new Frame<>(methodNode.maxLocals, methodNode.maxStack);
  int locals = fn.local!=null? fn.local.size(): 0;
  for(int lIx=0, lCount=locals; lIx<lCount; lIx++)
    current.setLocal(lIx, toBasicValue(ownerType, fn.local.get(lIx)));
  for(int lIx=locals; lIx<methodNode.maxLocals; lIx++)
    current.setLocal(lIx, BasicValue.UNINITIALIZED_VALUE);
  if(fn.stack!=null)
    for(Object obj: fn.stack) current.push(toBasicValue(ownerType, obj));
  return current;
}

private static Frame<BasicValue> methodEntryFrame(
    MethodNode methodNode, BasicValue ownerType, BasicInterpreter interpreter) {

  Frame<BasicValue> current = new Frame<>(methodNode.maxLocals, methodNode.maxStack);
  current.setReturn(interpreter.newValue(Type.getReturnType(methodNode.desc)));
  Type[] args = Type.getArgumentTypes(methodNode.desc);
  int local = 0;
  if((methodNode.access & Opcodes.ACC_STATIC) == 0)
    current.setLocal(local++, ownerType);
  for(int ix = 0; ix < args.length; ix++) {
    Type type = args[ix];
    current.setLocal(local++, interpreter.newValue(type));
    if(type.getSize() == 2)
      current.setLocal(local++, BasicValue.UNINITIALIZED_VALUE);
  }
  while(local < methodNode.maxLocals)
    current.setLocal(local++, BasicValue.UNINITIALIZED_VALUE);
  return current;
}

private static BasicValue toBasicValue(BasicValue owner, Object object) {
  if(object instanceof String) return refType(owner,(String)object);
  if(object instanceof Integer)
    switch((Integer)object) {
      case 0: return BasicValue.UNINITIALIZED_VALUE;
      case 1: return BasicValue.INT_VALUE;
      case 2: return BasicValue.FLOAT_VALUE;
      case 3: return BasicValue.DOUBLE_VALUE;
      case 4: return BasicValue.LONG_VALUE;
      case 5: return BasicValue.REFERENCE_VALUE;// null
      case 6: return owner;// uninitialized_this
      default: throw new IllegalStateException();
  }
  // uninitialized object, object is a LabelNode pointing to the ANEW instruction
  return BasicValue.REFERENCE_VALUE;
}

static final BasicValue OBJECT = new BasicValue(Type.getObjectType("java/lang/Object"));

private static BasicValue refType(BasicValue owner, String name) {
  if(name.equals("java/lang/Object")) return OBJECT;
  if(owner!=null && owner.getType().getInternalName().equals(name))
    return owner;
  return new BasicValue(Type.getObjectType(name));
}