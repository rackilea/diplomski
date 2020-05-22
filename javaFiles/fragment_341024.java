public void writeToFile(String username, String password) throws IOException {
    BufferedWriter out = new BufferedWriter(new FileWriter("file.txt"));
    out.write(username + "#" + password);
    out.newLine();
    out.close();
}