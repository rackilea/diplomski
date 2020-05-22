public void appendUsingBufferedWritter() 
  throws IOException {
    String str = "World";
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
    writer.append(' ');
    writer.append(str);

    writer.close();
}