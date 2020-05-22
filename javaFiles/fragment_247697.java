Pattern p = Pattern.compile(regexpr);

    System.out.println(p.matcher("fsdfsa").matches()); //false
    System.out.println(p.matcher("-").matches()); //false
    System.out.println(p.matcher("--").matches()); //true
    System.out.println(p.matcher("-----").matches()); //true