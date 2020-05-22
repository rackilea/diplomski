Pattern pat = Pattern.compile("(.*?)(\\[.*?\\])");
    Matcher matcher = pat.matcher(test);
    if (matcher.find()) {
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
    }