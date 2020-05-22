public static List<String> read(File file) {

List<String> content = new ArrayList<>();

try {

    BufferedReader reader = new BufferedReader(new FileReader(file));

    String line;

    while ((line = reader.readLine()) != null)
        content.add(getLineContent(line));

    reader.close();

} catch (Exception ex) {
    ex.printStackTrace();
}

return content;

}

private static String getLineContent(String line, List<String> content) {
    return line.contains(",") 
         ? getMultiValueContent(line)
         : line + "\n";
}

private static String getMultivalueContent(String line) {
    String multivalue;
    String[] values = line.replaceAll(",", "").split(" ");
    String typeValue = values[0];
    IntStream.range(1, values.size)
        .forEach(index -> multivalue = String.join("", multivalue, typeValue, values[index], "\n"))
    return multivalue; 
}