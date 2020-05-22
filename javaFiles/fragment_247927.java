/* Read each line and write it to all writers */
while (in.hasNextLine()) {
    String line = in.nextLine();
    for(PrintWriter writer : writers) {
        writer.println(line);
    }
}