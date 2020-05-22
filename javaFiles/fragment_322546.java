String[] patterns = { "ABC", "D(EF)", "XYZ" };
String input = "Lorem ipsum DEF dolor sit ABC amet, XYZ consectetur DEF adipiscing elit";

String[] names = new String[patterns.length];
StringBuilder regex = new StringBuilder();
for (int i = 0; i < patterns.length; i++) {
    Pattern.compile(patterns[i]); // validate
    names[i] = "Pattern" + (i+1);
    if (i != 0)
        regex.append('|');
    regex.append("(?<").append(names[i]).append('>').append(patterns[i]).append(')');
}
Pattern pattern = Pattern.compile(regex.toString());

for (Matcher matcher = pattern.matcher(input); matcher.find(); )
    for (int i = 0; i < patterns.length; i++)
        if (matcher.start(names[i]) != -1) {
            System.out.println("Found " + names[i] +
                               " at index " + matcher.start(names[i]) +
                               ": " + matcher.group(names[i]));
            break;
        }