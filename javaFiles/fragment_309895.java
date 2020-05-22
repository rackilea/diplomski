Pattern p = Pattern.compile("abc(.*?)");
    Matcher m = p.matcher("abc");
    while (m.find()) {
        System.out.println("hi");
        System.out.println("group1 : " +  m.group(1));
    }