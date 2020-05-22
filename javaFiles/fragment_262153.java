public void dumpTrace(){
    StackTraceElement[] stackTraceElements = Thread.currentThread()
        .getStackTrace();

    for (StackTraceElement element : stackTraceElements) {

        try {
            Class<?> clazz = Class.forName(element.getClassName());
            System.out.println("Looking for " + element.getMethodName() + " in class " + clazz);
            for (Method method : clazz.getMethods()){
                if(method.getName().equals(element.getMethodName())){
                    System.out.println("Possible match : " + method);
                }
            }
            for (Method method : clazz.getDeclaredMethods()){
                if(method.getName().equals(element.getMethodName())){
                    System.out.println("Possible match : " + method);
                }
            }
        } catch (Exception e) {
            //  oops do something here
        }
    }    
}