Pattern p = Pattern.compile("I want a (?:(salami|mushrooms|cheese)|(?:.*)) pizza");

String[] tests = { "I want a salami pizza", "I want a shrimp pizza" };

for (String s : tests) {
    Matcher m = p.matcher(s);
    if (m.matches()) {
        System.out.println(s + ": " + m.group(1));
    }
}