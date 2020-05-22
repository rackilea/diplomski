static boolean sameTypeAndLine(Throwable t1, Throwable t2) {
    if (t1.getClass() == t2.getClass()) {
        StackTraceElement[] trace1 = t1.getStackTrace();
        StackTraceElement[] trace2 = t2.getStackTrace();
        return trace1[0].equals(trace2[0]);
    } else {
        return false;
    }
}