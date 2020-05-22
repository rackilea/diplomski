Class<variable type> clazz = variable.getClass();
try {
    //Boolean.TYPE can be used instead of boolean.class
    Method m = clazz.getMethod("method_name", boolean.class);
    //method exists
 }
 catch(NoSuchMethodException e) {
      //method does not exist
 }