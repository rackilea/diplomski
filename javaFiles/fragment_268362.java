for (String block : input.split("#")) {
    Matcher m = p.matcher(block);
    if (m.matches()) {
        System.out.println(m.groupCount());
        for (int i = 0; i < m.groupCount(); i++) {
            System.out.println(m.group(i + 1));
        }
    }
}