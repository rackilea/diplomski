String input = "{xxxxx$ppp>5}&&{xxxxx.ppp==5}";
Matcher matcher = Pattern.compile("\\{[a-z0-9]+[$.][a-z0-9]+[><=]=?[0-9]\\}")
                         .matcher(input);
while (matcher.find()) {
    System.out.println(matcher.group()); // {xxxxx$ppp>5}
}                                        // {xxxxx.ppp==5}