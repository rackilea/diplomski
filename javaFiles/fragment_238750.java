String in = "A xx1 B xx2 C xx3 D";
    Matcher matcher = Pattern.compile("xx(\\d)").matcher(in);
    StringBuffer out = new StringBuffer();
    while (matcher.find()) {
        int num = Integer.parseInt(matcher.group(1));
        matcher.appendReplacement(out, Integer.toString(num*num));
    }
    System.out.println(matcher.appendTail(out).toString());