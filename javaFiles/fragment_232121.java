class Parent {
    private final String className;
    protected Parent() {
         StackTraceElement[] trace = new Throwable().getStackTrace();
         this.className = trace[1].getClassName();
    }
}