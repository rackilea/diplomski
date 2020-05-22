public static void main(String[] args) throws InterruptedException {
    List<String> list = Arrays.asList("a", "b", "c", "a", "d", "e", "a", "a", "b", "b", "a");
    int counter = 0;
    String mostFrequentWord = "";
    for (String streamed : list) {
        if (streamed.equals(mostFrequentWord)) {
            counter++;
        } else if (counter == 0) {
            mostFrequentWord = streamed;
            counter = 1;
        } else {
            counter--;
        }
    }
    System.out.println(mostFrequentWord);
}