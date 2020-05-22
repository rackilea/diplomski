String[][] s1 = {{new String("a"), new String("b")}};
    String[][] s2 = s1.clone();
    System.out.println(Arrays.toString(s1)); // prints [[Ljava.lang.String;@7440e464]
    System.out.println(Arrays.toString(s2)); // prints [[Ljava.lang.String;@7440e464]
    System.out.println(s1[0] == s2[0]); // prints true
    System.out.println(s1 == s2); // prints false - because s2 != s1