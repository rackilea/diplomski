String classPrefixName = "com.your.company.A";
for (int i = 0; i< 300; i++) {
    Class<?> clazz = Class.forName(classPrefixName+i); //look for the class
    Method method = clazz.getDeclaredMethod("staticInit"); //look for the method
    method.invoke(null); //invoke(null), since it's a static method
}