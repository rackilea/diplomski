String regex = "(A\n)|(B\n)|(C\n)";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(input);

// Find all matches
while (matcher.find()) {
    if (matcher.group(1) != null)
        System.out.println("Found pattern A at index " + matcher.start(1));
    else if (matcher.group(2) != null)
        System.out.println("Found pattern B at index " + matcher.start(2));
    else
        System.out.println("Found pattern C at index " + matcher.start(3));
}