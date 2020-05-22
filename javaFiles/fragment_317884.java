try {
    BufferedWriter out = new BufferedWriter(new FileWriter("outfilename"));
    out.write("aString");
    out.close();
} catch (IOException e) {
    // Handle exception
}