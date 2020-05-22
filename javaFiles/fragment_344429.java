public static void main(String[] args) {
    Pattern p = Pattern.compile("ENERGY:\\s(.*)");
    String st = "1562173405047|INFO|MyHalfDuplexModem@30:println|ENERGY: -s 1 -d 2 -b 288 -e 9.999788799994675071125   T   {-s 1, -d 2 }\n" +
            "1562173405552|INFO|MyHalfDuplexModem@43:println|ENERGY: -s 3 -d 2 -b 96 -e 9.999779196127731100294   R   {-s 3, -d 2 }\n" +
            "1562173406122|INFO|MyHalfDuplexModem@43:println|ENERGY: -s 1 -d 2 -b 288 -e 9.999764796127731100294   R   {-s 1, -d 2 }\n" +
            "1562173406194|INFO|MyHalfDuplexModem@43:println|ENERGY: -s 2 -d 1 -b 96 -e 9.999759995924876667052   T   {-s 2, -d 1 }";
    Matcher mt = p.matcher(st);

    while (mt.find()) {
        String group = mt.group(1);
        System.out.println(group);
    }
}