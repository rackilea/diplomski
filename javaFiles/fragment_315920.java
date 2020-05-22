// Converts a file to a string
private String fileToString(String filename) throws IOException
{
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    StringBuilder builder = new StringBuilder();
    String line;    

    // For every line in the file, append it to the string builder
    while((line = reader.readLine()) != null)
    {
        builder.append(line);
    }

    reader.close();
    return builder.toString();
}