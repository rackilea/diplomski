public void runTest() {
        if (toChange.length() > 10) {
            toChange = "";
        }
        Random rand = new Random();
        toChange += rand.nextInt(10);
}