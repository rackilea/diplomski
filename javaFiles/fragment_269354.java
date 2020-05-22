public final synchronized void add(T... args) {
    boolean isSubmitted = true;
    if (arguments == null) {
        isSubmitted = false;
        arguments = new ArrayList<T>();
    }
    Collections.addAll(arguments, args); // <-----
    if (!isSubmitted) { //This is what will make that for multiple publishes only one process is executed
        submit(); // <-----
    }
}