class Lines{
    public static void join(String endLine, Reader reader, Writer writer) throws IOException {
        String line;

        BufferedReader bufferedReader = new BufferedReader(reader);
        while ((line = bufferedReader.readLine()) != null) {
            String tLine = line.trim();

            writer.write(tLine);
            if (tLine.equals(endLine)) {
                writer.write(System.lineSeparator());
            }
        }
    }
}