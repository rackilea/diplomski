try {
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    textArea.read(br, "Stream description");
} catch (IOException e2) {
    e2.printStackTrace();
}