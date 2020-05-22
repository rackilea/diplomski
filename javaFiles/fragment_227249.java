public void read() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Press Enter to continue");
    try {
        System.in.read();
    } catch (IOException e) {
        e.printStackTrace();
    }
    if (scanner.hasNextLine()) {
        scanner.nextLine(); // Remove '\n' from the buffer
        this.win();
    }
}