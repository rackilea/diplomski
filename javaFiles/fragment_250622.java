public static void main(String[] args) {
    String s = "Hey {1}, you are {2}.";
    HashMap<Integer, String> hm = new HashMap();
    hm.put(1, "one");
    hm.put(2, "two");
    Pattern p = Pattern.compile("(\\{\\d+\\})");
    Matcher m = p.matcher(s);
    while (m.find()) {
        System.out.println(m.group());
        String val1 = m.group().replace("{", "").replace("}", "");
        System.out.println(val1);
        s = (s.replace(m.group(), hm.get(Integer.parseInt(val1))));
        System.out.println(s);
    }

}