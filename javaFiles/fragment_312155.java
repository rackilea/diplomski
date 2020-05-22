public static void main(String[] args) throws IOException {

    String fileName = "createF dir\\text.txt"; 
    String textToFile="apples, oranges";

    String splitter[] = fileName.split(" ");

    String actualPath = splitter[1];

    File file = new File(actualPath);
    if (file.getParentFile().mkdir()) {
        file.createNewFile();
        new FileOutputStream(actualPath).write(textToFile.getBytes());
    } else {
        throw new IOException("Failed " + file.getParent());
    }
}