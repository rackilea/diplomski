Pattern p = Pattern.compile("<[^>]*>");
    Matcher m = p.matcher("<a> b c <ddd> e <ff> g <$$$> i <jjj>");

    System.out.println(replaceUppercase(4, m));
    // <A> b c <DDD> e <FF> g <$$$> i <jjj>
    //  1        2       3      4