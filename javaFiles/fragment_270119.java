public static void makefile(double n, String fileName) throws IOException {
    FileWriter fileWriter = new FileWriter(fileName);
    PrintWriter printWriter = new PrintWriter(fileWriter);
    Random rand = new Random();

    for (int i = 0; i < n; i++) {
        printWriter.println(rand.nextDouble());  // <--- observe this
    }
    if (printWriter != null) {
        printWriter.flush();
        printWriter.close();
    }
}