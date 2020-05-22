Pattern pattern = Pattern.compile("(A(B|C)?) D (E(F|G)?)");
Matcher matcher = pattern.matcher("A D EG");
if (matcher.matches()) {
    System.err.println(matcher.group(1));
    System.err.println(matcher.group(2));
    System.err.println(matcher.group(3));
    System.err.println(matcher.group(4));
}