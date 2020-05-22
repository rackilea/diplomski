String input = "123";
String regex = "\\d";
Matcher m = Pattern.compile(regex).matcher(input);

String[] output = new String[input.length()];
int index = 0;

while (m.find())
    output[index++] = m.group();

for (String s : output)
    System.out.println(s);