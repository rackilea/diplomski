while(m.find()) {
    char[] replace = new char[m.group().length()];
    Arrays.fill(replace, '*');
    m.appendReplacement(bf, new String(replace));
}
m.appendTail(bf);