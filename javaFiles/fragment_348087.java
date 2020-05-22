public static void StringReplace() {
    String data = "{1:F01ANZBDEF0AXXX0509036846}{2:I103ANZBDEF0XXXXN}{4::20:TEST000001:23B:CRED:32A:141117EUR0,1:33B:EUR1000,00:50A:ANZBAU30:59:ANZBAU30:71A:SHA-}{5:{CHK:1DBBF1D81EE1}{TNG:}}";

    Pattern pat = Pattern.compile("(.*)(\\{4.*?\\})(.*)");
    Matcher m = pat.matcher(data);

    if (m.find()) {
        String g1 = m.group(1);
        String g2 = m.group(2).replaceAll(":(?=\\w{2,3}:)", " :");
        String g3 = m.group(3);
        System.out.println(g1 + g2 + g3);
    } else {
        System.out.println("Didn't match");
    }
}