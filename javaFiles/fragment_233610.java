ClassPool pool = ClassPool.getDefault();
CtClass cc = pool.get("Wrirter");
ConstPool classConstantPool = cc.getClassFile().getConstPool();
for (String className : (Set<String>) classConstantPool.getClassNames()) {
    System.out.println("className = " + className);
}