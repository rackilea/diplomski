public static void main(String[] args)  {
    String s1 = "number-20150606.text_1.xml";
    String s2 = "20150606.text_1.xml";

    Pattern p =Pattern.compile("(.*?)-?(\\d{8})");
    Matcher m = p.matcher(s1);
    while(m.find()) {

        System.out.println(m.group(1));
        System.out.println(m.group(2));
    }
    m = p.matcher(s2);
    while(m.find()) {

        System.out.println(m.group(1));
        System.out.println(m.group(2));
    }
}