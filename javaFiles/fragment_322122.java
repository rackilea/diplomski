String input = "LB03452 - Test, name of the file B12345, test2 - name of second file";
List<String> output = new ArrayList<>();
Pattern p = Pattern.compile("(B|M|CB|CM|LB|LM)[0-9]+");
Matcher m = p.matcher(input);

while (m.find()) {
    output.add(m.group());
}