Matcher m = p.matcher(input);
while (m.find()) {
    System.out.println(m.groupCount());
    for (int i = 0; i < m.groupCount(); i++) {
        System.out.println(m.group(i + 1));
    }
}