public static void addInstrumentation(CtClass ctClass, CtMethod ctMethod) throws NotFoundException, CannotCompileException {
    if (ctClass.getName().startsWith("com.application.bookstore.entities.test")) {
        String testName = ctClass.getName() + "." + ctMethod.getName();
        String fileToWrite = "C:/profiler/root.txt";
        ctMethod.insertBefore("{ com.application.bookstore.entities.test.ClassWithTheStaticField.lastTestMethod = " + testName + "; FileWriter fw = new FileWriter(\"" + fileToWrite + "\", true); BufferedWriter out = new BufferedWriter(fw); out.write(\"" + testName + "\"); out.newLine(); out.close(); }");
    }
    else {
        String methodName = ctClass.getName() + "." + ctMethod.getName() + "()";
        String fileToRead = "C:/profiler/root.txt";
        ctMethod.insertBefore("{ FileWriter fw = new FileWriter(com.application.bookstore.entities.test.ClassWithTheStaticField.lastTestMethod, true); BufferedWriter out = new BufferedWriter(fw); out.write(\"" + methodName + "\"); out.newLine(); out.close(); }");
    }
}