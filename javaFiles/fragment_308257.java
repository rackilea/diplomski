String s="hello foo33 world bar12\n"+
            "bar66 something foo14\n"+
            "this one only has bar45\n"+
            "this one has neither";
    Pattern pattern = Pattern.compile("(foo|bar)\\d{2}");
    Matcher matcher = pattern.matcher(s);
    while (matcher.find()) {
        System.out.println(matcher.group());
    }