enum SaveableSingleton {
    INSTANCE;

    String name;
    int value;

    public void load(String filename) throws IOException {
        try (Scanner scanner = new Scanner(new File(filename))) {
            name = scanner.nexLine();
            value = scanner.nextInt();
        }
    }

    public void save(String filename) throws IOException {
        try (PrintWriter pw = new PrintWriter(new File(filename))) {
            pw.println(name);
            pw.println(value);
        }
    }
}