String input = "2x^2 - 4x + 1";
input = input.replaceAll("\\s", ""); //removes  all whitespaces

Pattern p = Pattern.compile("(-?\\d+)x\\^2((\\+|-)\\d+)x((\\+|-)\\d+)");
Matcher m = p.matcher(input);

if (!m.matches()) {
    System.out.println("Incorrect input");
    return;
}

int a, b, c;
a = Integer.parseInt(m.group(1));
b = Integer.parseInt(m.group(2));
c = Integer.parseInt(m.group(4));

System.out.println(String.format("a=%d, b=%d, c=%d", a, b, c));