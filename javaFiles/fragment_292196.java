String sql = "... put it here ...";

    String regex = "(PRIMARY|UNIQUE) KEY[ `a-zA-z]+\\(`([a-zA-Z]+)`\\)";
    Matcher matcher = Pattern.compile(regex).matcher(sql);
    while (matcher.find()) {
        System.out.println(matcher.group(1) + ": " + matcher.group(2));
    }