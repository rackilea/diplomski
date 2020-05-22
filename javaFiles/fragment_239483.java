for (String s : input) {
    Matcher m = p.matcher(s);
    while (m.find()) {
        System.out.println(m.group());
    }
}