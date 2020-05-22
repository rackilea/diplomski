public static boolean isIdeaRunningTheTest() {
   try {
     final Class<?> aClass = Class.forName("com.intellij.rt.execution.junit.JUnitStarter");
     } catch (ClassNotFoundException e) {
        return false;
     }

     return true;
}