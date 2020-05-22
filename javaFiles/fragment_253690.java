void addTestCasesFromClass(Class<?> clz)
{
     for(String methodName : getPublicDeclaredMethods(clz))
     { 
         this.addTest(clz.getConstructor(String.class).newInstance(methodName));
     }
}