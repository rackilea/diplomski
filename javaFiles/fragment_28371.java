public int search(String text, String filePath) throws IOException {
    int count = 0;
    String line;
    text = text.toLowerCase();
    FileReader fr = new FileReader(filePath);
    BufferedReader br = new BufferedReader(fr);
    while ((line = br.readLine()) != null) {
        int fromIndex = 0;
        int index = -1;
        while ((index = line.toLowerCase().indexOf(text, fromIndex)) != -1) {
            count++;
            fromIndex = index + text.length();
        }

    }

    fr.close();
    br.close();

    return count;
}