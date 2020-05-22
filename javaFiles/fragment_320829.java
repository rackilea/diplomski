String text = "String prefix without commas, variable length ())(remainde()r with )optional (suffix (optional suffix)";
Pattern regex = Pattern.compile("^([^,]*),(.*?)(?:[(]([^()]*)[)])?\\s*$");
Matcher m = regex.matcher(text);
if (m.find()) {
    System.out.println("1: " + m.group(1));
    System.out.println("2: " + m.group(2));
    System.out.println("3: " + m.group(3));
}