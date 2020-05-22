String s= "Verify Payment 2";

    Pattern p =Pattern.compile("(.+)\\s(\\w+)");

    Matcher m = p.matcher(s);
    if (m.find()){
        System.out.println("String 1 ="+m.group(1));
        System.out.println("String 2 ="+m.group(2));
    }