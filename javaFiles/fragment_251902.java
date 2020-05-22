CtField field = new CtField(ClassPool.getDefault().get("the.replacement.classB"), "classB", ctClass);
ctClass.addField(field, CtField.Initializer.byExpr("new the.replacement.classB()"));
for (CtMethod method : ctClass.getMethods()) {
    method.instrument(new ExprEditor() {
        public void edit(MethodCall methodCall) throws CannotCompileException {
           if (methodCall.getMethodName().equals("doSomething") && methodCall.getClassName().getClassName().equals("the.original.ClassA")) {
               methodCall.replace("classB.doSomething($1)");
           }
      }
}