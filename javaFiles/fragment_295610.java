public static void main(final String[] args) throws FileNotFoundException,
        IOException {
    final File f = new File("/tmp/output");

    final ObjectOutputStream oos = new ObjectOutputStream(
            new FileOutputStream(f));

    for (int i = 0; i < 8; i++) {
        final double d = Math.sin(i);
        System.out.println(d);
        oos.writeDouble(d);
    }

    oos.flush();
    oos.close();

    System.out.println("---");

    final ObjectInputStream ois = new ObjectInputStream(
            new FileInputStream(f));

    for (int i = 0; i < 8; i++)
        System.out.println(ois.readDouble());

    ois.close();

}