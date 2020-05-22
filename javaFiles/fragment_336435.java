StackTraceElement aParentStack = new Throwable().fillInStackTrace().getStackTrace()[1];
System.out.println(aParentStack.getClassName());
System.out.println(aParentStack.getFileName());
System.out.println(aParentStack.getLineNumber());
System.out.println(aParentStack.getMethodName());
System.out.println((aParentStack.isNativeMethod() ? "Native" : "Java") + " method");