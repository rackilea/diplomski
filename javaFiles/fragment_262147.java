String sourceAddress = "abcdef";
    String s = sourceAddress.substring(0, 2);
    s += ".";
    s += sourceAddress.substring(2, 4);
    s += ".";
    s += sourceAddress.substring(4, 6);
    System.out.println(s);