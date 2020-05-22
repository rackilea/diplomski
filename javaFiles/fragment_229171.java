ClassFile cf = ...;
 MethodInfo minfo = cf.getMethod("yourMethod");
 Bytecode code = new Bytecode(cf.getConstPool());
 // insert your logic here
 code.addAload(0);
 code.addInvokespecial("java/lang/Object", MethodInfo.nameInit, "()V");
 code.addReturn(null);
 code.setMaxLocals(1);

 MethodInfo minfo = new MethodInfo(cf.getConstPool(), MethodInfo.nameInit, "()V");
 minfo.setCodeAttribute(code.toCodeAttribute());