public static void main(String[] args) {
    Sync hi = new Sync();
    Thread t = new Thread(hi);
    t.start();

    Scanner d = new Scanner(System.in);
    System.out.println("press enter to pause");
    d.nextLine();
    hi.setPaused(true);
    System.out.println("press enter to resume");
    d.nextLine();
    hi.setPaused(false);
    System.out.println("press enter to terminate");
    d.nextLine();
    hi.terminate();

    try {
        t.join();
    } catch (InterruptedException ex) {
        ex.printStackTrace();
    }

    System.out.println("Has terminated");
}