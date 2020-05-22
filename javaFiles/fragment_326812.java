public static void main(String[] args) throws InterruptedException {
    List<String> my_words = new LinkedList<String>();
    my_words.add("1153 3494 9509 2 0 0 0 0");
    my_words.add("1153 3487 9509 2 0 0 0 0");
    my_words.add("1153 3491 9525 2 0 0 0 0");
    my_words.add("1153 3464 9513 2 0 0 0 0");

    Random rand = new Random();
    while (true) {
        int choice = rand.nextInt(my_words.size());
        System.out.println("Choice = " + my_words.get(choice));
        Thread.sleep(1000);
        int replaceTo = rand.nextInt(my_words.size());          
        System.out.println("Replace to = " + my_words.get(replaceTo));
        my_words.set(choice, my_words.get(replaceTo));          
    }
}