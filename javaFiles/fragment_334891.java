public static Val test() throws Exception {
    try {
        return doSomething();
    } catch (Exception e) {
        throw new Exception("No!");
    }
    // Unreachable code goes here
}