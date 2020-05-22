class Main {
    public static void main(String[] args) throws InterruptedException {
        String[] spinner = new String[] {"\u0008/", "\u0008-", "\u0008\\", "\u0008|" };
        Console console = System.console();
        console.printf("|");
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(150);
            console.printf("%s", spinner[i % spinner.length]);
        }
    }
}