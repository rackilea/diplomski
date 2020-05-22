LinkedList<String> stack = new LinkedList<String>();
    SpreadSheet myClass = new SpreadSheet();
    Class objClass = myClass.getClass();
    String methodName = stack.pop();
    Class<String>[] parameterTypes = new Class[stack.size()];
    java.util.Arrays.fill(parameterTypes,String.class);  // fill the array with String.class Object
    Method meth1 = objClass.getDeclaredMethod(methodName, parameterTypes);
    meth1.invoke(myClass, stack.toArray());