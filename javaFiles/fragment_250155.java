String s = "2011-10-20 525 14:28:55 10";
    Pattern p = Pattern.compile("(^|\\s)([0-9]+)($|\\s)");
    Matcher m = p.matcher(s);
    if (m.find()) {
        System.out.println(m.group(2));
    }