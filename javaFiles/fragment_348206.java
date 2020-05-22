public static void main(String... args) {
    int testLength = 100 * 1000 * 1000;
    String[] stringArray = new String[testLength];
    Arrays.fill(stringArray, "a");
    List<String> stringList = new ArrayList<String>(Arrays.asList(stringArray));
    {
        long start = System.nanoTime();
        long total = 0;
        for (String str : stringArray) {
            total += str.length();
        }
        System.out.printf("The for each Array loop time was %.2f ns total=%d%n", (double) (System.nanoTime() - start) / testLength, total);
    }
    {
        long start = System.nanoTime();
        long total = 0;
        for (int i = 0, stringListSize = stringList.size(); i < stringListSize; i++) {
            String str = stringList.get(i);
            total += str.length();
        }
        System.out.printf("The for/get List loop time was %.2f ns total=%d%n", (double) (System.nanoTime() - start) / testLength, total);
    }
    {
        long start = System.nanoTime();
        long total = 0;
        for (String str : stringList) {
            total += str.length();
        }
        System.out.printf("The for each List loop time was %.2f ns total=%d%n", (double) (System.nanoTime() - start) / testLength, total);
    }
}