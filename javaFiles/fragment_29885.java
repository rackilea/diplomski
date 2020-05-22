String input = "...some input...";
Pattern pattern = Pattern.compile("^(?: {4})+(?=.+)", Pattern.MULTILINE);
Matcher m = pattern.matcher(input);

// Using iterator doing the /g part here
while (m.find()) {
    System.out.println(m.group(1));
}