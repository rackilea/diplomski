final String a = "a";
    final String b = "b";
    final String ab = a + b;
    final String ab2 = "a" + b;
    final String ab3 = "a" + new String("b");
    System.out.println("ab == ab2 should be true:  " + (ab == ab2));
    System.out.println("a+b == ab should be true:  " + (a+b == ab));
    System.out.println("ab == ab3 should be false: " + (ab == ab3));