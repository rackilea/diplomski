public static void writeStringToFile(String string, String  filePath) throws IOException {

    BufferedWriter writer = new BufferedWriter(
            new FileWriter(
                    new File(filePath)
                    )
            );

    writer.write(string);

    writer.newLine();
    writer.flush();
    writer.close();

}