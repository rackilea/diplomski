String str = "admins";
    Pattern pattern = Pattern.compile(".{2}");
    Matcher matcher = pattern.matcher(str);
    while (matcher.find()) {
        String match = matcher.group();
        System.out.println(match);
    }