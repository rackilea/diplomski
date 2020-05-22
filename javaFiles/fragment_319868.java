String test = "Something[Anything]";
    if (test.matches(".*\\[.*\\].*")) { // checks if in the string presents open and close square brackets
        Pattern pat = Pattern.compile("(.*?)(\\[.*?\\])");
        Matcher matcher = pat.matcher(test);
        matcher.find();
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
    }