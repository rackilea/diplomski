String regex="^q(?=u)u";
    Pattern p= Pattern.compile(regex);
    String test = "qu";
    Matcher m= p.matcher(test);
    System.out.println(m.matches());
    System.out.println(m.lookingAt());