String s = "0.1.2\n" +
        "[2.2.0, 2.2.1, 2.2.2, 2.2.3]";
Matcher m = Pattern.compile("\\d\\.\\d\\.(\\d)\n(.+)").matcher(s);
if (m.find()) {
    int lastDigit = Integer.parseInt(m.group(1)); // find the last digit on first line
    String secondLine = m.group(2);

    // now find triplets on the second line
    m = Pattern.compile("(\\d)\\.(\\d)\\.(\\d)").matcher(secondLine);
    while (m.find()) {

        // here I printed the digits out. You can do whatever you like with "m.group(lastDigit)"
        System.out.println(m.group(lastDigit));
    }
}