String str = "INSERT %ABC% %DEF%";
    Pattern p = Pattern.compile("%(.*?)%");
    Matcher m = p.matcher(str);
    while(m.find())
    {
        System.out.println(m.group(1));
    }