String str = "(this && that)\",\"(these&&those)\",\"(me&&you)";
    Pattern pattern = Pattern.compile("\\(([^\\)]+)\\)");
    Matcher m = pattern.matcher(str);
    while (m.find()){
        System.out.println(m.group(0));
    }