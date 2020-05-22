public void doSomething(String name) {
    if (name.equals("hello")) {
        if (log_.isInfoEnabled()) { // Don't want to have this code everywhere
            logInfo("What class name does the log print here ? ") 
        }
    }
}