String s1 = ".............";
    String s2 = "xx";
    int p = 1;
    String s3 = s1.substring(0, p)  + s2 + s1.substring(p + s2.length());
    System.out.println(s1);
    System.out.println(s3);