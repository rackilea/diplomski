class A {
    getName()
    {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        int lastStackElement = stackTraceElements.length-1;
        String callingObjectsName = stackTraceElements[lastStackElement].getClassName();
        System.out.println(callingObjectsName + " called me.");
    }
}