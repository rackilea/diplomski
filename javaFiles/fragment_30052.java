Pattern pattern = Pattern.compile("\\d+(?:\\.\\d+)?(\\s\\d+(?:\\.\\d+)?)*\\s*[-+*/$£]|[-+*/$£]");

String input = "4.0 5.0 2.0 / + 7.0 - 11.0 34.0 2.0 / 3.0 / 1.0 * +";
Matcher matcher = pattern.matcher(input);
ArrayList<String> output = new ArrayList<String>();
while (matcher.find()) {
    output.add(matcher.group());
}
for (String s: output)
{
    System.out.println(s);
}