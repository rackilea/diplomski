// Float.MAX_VALUE = 3.4028234663852886E38f
    float f = Float.parseFloat("1.11111111111111E+49");
    System.out.println("f=" + f);   // -> f=Infinity

    // Double.MAX_VALUE = 1.7976931348623157E308
    double d = Double.parseDouble("1.11111111111111E+49");
    System.out.println("d=" + d);   // -> d=1.11111111111111E49