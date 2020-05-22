String str = "[\"String1\", \"String2\", \"oneMoreString\"]";

    Pattern pattern = Pattern.compile("\"(.+?)\"");
    Matcher matcher = pattern.matcher(str);

    List<String> list = new ArrayList<String>();
    while (matcher.find()) {
        // System.out.println(matcher.group(1));.
        list.add(matcher.group(1));
    }