String[] input = new String[]{"MOC.OOHAY@ABC.PQRqwertySDdd","MOC.OOHAY@AB.JKLasDDbfn" , "MOC.OOHAY@XZ.JKGposDDbfn"};
    Pattern p = Pattern.compile("([A-Z.]+@[A-Z.]+)");
    for(String string : input)
    {
        Matcher matcher = p.matcher(string);
        if(matcher.find())
            System.out.println(matcher.group(1));
    }