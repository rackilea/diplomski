public void readFile(String path) {
    try {
        FileReader reader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}