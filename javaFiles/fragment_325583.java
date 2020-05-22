try {
    BufferedWriter writer = new BufferedWriter(new FileWriter("file1.txt", true));
    Scanner keyboard = new Scanner(System.in);
    String next;
    do {
        next = keyboard.next();
        writer.write(next);
        writer.newLine();
    } while (!next.equals("abc"));
    writer.close();
} catch (IOException e) {
    e.printStackTrace();
}