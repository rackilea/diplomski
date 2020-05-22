public static Val test() throws Exception {
    Val toReturn = null;
    try {             
        toReturn = doSomething();
    } catch (Exception e) {
        throw new Exception("No!");
    }
    return toReturn;
}