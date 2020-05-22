String str = "1, 2 and 3, 93";

    Matcher m = Pattern.compile("\\d+").matcher(str);
    while (m.find()) {
        System.out.println(m.group(0));
    }