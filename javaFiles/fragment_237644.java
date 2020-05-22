public Method getDynMethod(Class aClass, String methodName) {
   for (Method m : aClass.getMethods()) {
       if (methodName.equals(m.getName())) {
           Class<?>[] params = m.getParameterTypes();
           if (params.length == 1 
               && (params[0] == Long.class || params[0] == String.class)) {
               return m;
           }
       }
    }

    return null;
}