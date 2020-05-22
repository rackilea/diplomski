public static void main(String[] args) throws Exception {
    String s;
    Scanner scanner = new Scanner(new File("c:/temp/x.txt"));
    while( ! "=".equals((s = scanner.next()))) {
        // Ignore - getting to start
    }

    while( ! "==".equals((s = scanner.next()))) {
        // Put in first array
        System.out.println("First section: " + s);
    }

    while( ! "===".equals((s = scanner.next()))) {
        // Put in first array
        System.out.println("Second section: " + s);
    }

    // etc...
}