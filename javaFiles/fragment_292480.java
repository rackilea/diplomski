protected static void append(File file, BufferedWriter bw) throws IOException {

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String text = null;
        while ((text = br.readLine()) != null) {
            bw.write(text);
            bw.newLine();
        }
    } finally {
    }

}