Throwable t = new Throwable();
StackTraceElement[] elements = t.getStackTrace();

String calleeMethod = elements[0].getMethodName();
String callerMethodName = elements[1].getMethodName();
String callerClassName = elements[1].getClassName();

System.out.println("CallerClassName=" + callerClassName + " , Caller method name: " + callerMethodName);
System.out.println("Callee method name: " + calleeMethod);