int i = Short.MAX_VALUE;
    short b = (short) i;
    System.out.println(i +" -> "+ b);
    System.out.println("" + Integer.toBinaryString(0xFFFF & b));

    i = Short.MAX_VALUE + 1;
    b = (short) i;
    System.out.println(i +" -> "+ b);
    System.out.println("" + Integer.toBinaryString(0xFFFF & b));

    i = Short.MAX_VALUE + Short.MAX_VALUE + Short.MAX_VALUE;
    b = (short) i;
    System.out.println(i +" -> "+ b);
    System.out.println("" + Integer.toBinaryString(0xFFFF & b));