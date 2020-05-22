String x = "###.###";
    List<String> s = Arrays.asList(x.split("[.]"));
    int x1 = s.get(0).length();
    int x2 = s.get(1).length();

    //[0-9]{1,"+x1+"} => match digit before the decimal point with occurrence 1-x1
    //[0-9]{0,"+x2+"} => match digit after the decimal point 0-x2
    //.{0,1} => match the decimal point
    Pattern p = Pattern.compile("^[0-9]{1,"+x1+"}.{0,1}[0-9]{0,"+x2+"}$");

    Matcher matcher = p.matcher("123.33");
    System.out.println(matcher.matches());//true