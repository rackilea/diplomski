public class MethodFinder {

  public static void main(String[] args) throws Throwable {
    ClassPool cp = ClassPool.getDefault();
    CtClass ctClass = cp.get("MyClass");
    CtMethod method = ctClass.getDeclaredMethod("getItem1");
    method.instrument(
        new ExprEditor() {
            public void edit(MethodCall m)
                          throws CannotCompileException
            {
                System.out.println(m.getClassName() + "." + m.getMethodName() + " " + m.getSignature());
            }
        });
  }
}