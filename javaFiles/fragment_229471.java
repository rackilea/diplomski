public static void main(String[] args) throws Exception {
    File dir = new File("C://Users//Test//Desktop//lists");

    if (dir.isDirectory()) {
        BufferedWriter writer = new BufferedWriter(new FileWriter("C://Users//Test//Desktop//logged.txt"));

        for (File file : dir.listFiles()) {
            String line1 = Files.readAllLines(Paths.get(file.getAbsolutePath())).get(0);
            writer.write(line1);
            writer.newLine();
        }
        writer.close();

    }
}