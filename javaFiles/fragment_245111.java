public static void main(String[] args) {
    int[] array = { 1, 2, 3 };
    writeOut(array);
    List<Integer> list = readIn();
    for (Integer num : list) {
        System.out.print(num + " " );
    }
}

public static List<Integer> readIn() {
    final File file = new File("file.txt");
    List<Integer> list = new ArrayList<Integer>();
    Scanner scan;
    try {
        scan = new Scanner(file);
        while (scan.hasNextInt()) {
            list.add(scan.nextInt());
        }
    } catch (FileNotFoundException e) {
    }
    return list;
}

public static void writeOut(int[] array) {
    final File file = new File("file.txt");

    try {
        file.createNewFile();
        final FileWriter writer = new FileWriter(file);

        for (int i = 0; i < array.length; i++) {
            writer.write(Integer.toString(array[i]) + " ");
        }
        writer.close();
        writer.flush();
    } catch (final IOException e) {
    }
}