String data = "this is amazing /* comment */ more data ";
    Pattern pattern = Pattern.compile("/\\*.*?\\*/");

    Matcher matcher = pattern.matcher(data);
    while (matcher.find()) {
        // Indicates match is found. Do further processing
        System.out.println(matcher.group());
    }