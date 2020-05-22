BufferedReader br = new BufferedReader(new FileReader(file));
String input;
while ((input = br.readLine()) != null) {
    String text = input.replaceAll("[^0-9]+","");
    if (!text.isEmpty())
        lines.add(Integer.parseInt(text));
}