Object around() : timerTaskRun() {
    Object o;
    try {
        o = proceed();   
    } catch(RuntimeException e) {
        System.out.println("log and swallow " + e.getCause().getMessage());
        o = null;
    }
    return o;
}