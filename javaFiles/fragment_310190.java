while (true){
    // Note -- lambda is 5 seconds, convert to milleseconds
    long interval= (long)poissonRandomInterarrivalDelay(5.0*1000.0);
    try {
        Thread.sleep(interval);
        fireEvent();
}