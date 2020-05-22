String input = "Hello today is 03/17 current time is 03:20 humidity is 50%";
Pattern p = Pattern.compile("(.*) today is (.*) current time is (.*) humidity is (.*)");
Matcher m = p.matcher(input);
if (m.find()) {
        System.out.println("Found greeting: " + m.group(1));
        System.out.println("Found date: " + m.group(2));
        System.out.println("Found time: " + m.group(3));
        System.out.println("Found humidity: " + m.group(4));
}