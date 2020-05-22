BufferedWriter br;
try {
    br = new BufferedWriter(new FileWriter(new File("text.txt")));
    br.write("This should be present in the file.");
    br.close();
} catch (IOException e) {
    e.printStackTrace();
}