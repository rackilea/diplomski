String s = new String("hell");
    String hello = "hello";
    s += 'o';
    System.out.println(hello == hello.intern()); //True
    System.out.println(s == s.intern());         //False
    System.out.println(s == hello);              //False
    System.out.println(s.intern() == hello);     //True
    //To sum up : s != s.intern() == hello.intern() == hello