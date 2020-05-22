String s="R12T12W5P12T5L3";
    String regex = "([A-Z]\\d+){2}";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(s);
    while(m.find()){
        System.out.println(m.group(0));
    }