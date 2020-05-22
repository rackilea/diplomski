public static void main(String[] args) throws IOException {
    String[] a = new String[] {"V123,V20", "10,9999", "100,V220"};

    for (String s: a) {
        Pattern p = Pattern.compile("[\\D0]*(\\d*)[\\D0]*(\\d*)",Pattern.MULTILINE);
        Matcher m = p.matcher(s);
        System.out.println(m.matches());
        System.out.println(m.group(1) + ", " + m.group(2));
    }
}