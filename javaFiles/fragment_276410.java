String str= "[7^^http://www.w3.org/2001/XMLSchema#integer,...]";
    Pattern p = Pattern.compile("\\[(.*)\\^\\^.*");
    Matcher m = p.matcher(str);
    if(m.matches()) {
            System.out.println(m.group(1));
    }