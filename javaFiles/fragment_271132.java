public BufferedReader readFromFile(String path) {
    try {
        return new BufferedReader(new FileReader(path));
    } catch (IOException e) {
        e.printStackTrace();
    }
}