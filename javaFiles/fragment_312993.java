try {
    Scanner input = new Scanner(Paths.get(fileName));
    //...
} finally {
    // This is null because the instance field has not been initialised
    input.close();
}