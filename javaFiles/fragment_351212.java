public void removeLine(final File file, final int lineIndex) throws IOException{
    final List<String> lines = new LinkedList<>();
    final Scanner reader = new Scanner(new FileInputStream(file), "UTF-8");
    while(reader.hasNextLine())
        lines.add(reader.nextLine());
    reader.close();
    assert lineIndex >= 0 && lineIndex <= lines.size() - 1;
    lines.remove(lineIndex);
    final BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
    for(final String line : lines)
        writer.write(line);
    writer.flush();
    writer.close();
}