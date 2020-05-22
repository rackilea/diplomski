public boolean isValidURL() {
    for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
        if (ste.getClassName().equals(Thread.class.getName())
                || ste.getClassName().equals(getClass().getName()))
            continue;
        System.out.println(ste.getClassName() + "." + ste.getMethodName());
        break;
    }
    return true;
}