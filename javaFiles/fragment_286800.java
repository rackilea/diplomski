Pattern p = Pattern.compile("[a-zA-Z0-9_]+");
Matcher m = p.matcher(s);

for (String s : keyList) {
    if (!m.matches()) {
        System.out.println(s);
    }
}