Chronology ch1 = GregorianChronology.getInstance();
    Chronology ch2 = ISOChronology.getInstance();

    DateTime dt = new DateTime("2013-12-31T22:59:21+01:00",ch1);
    DateTime dt2 = new DateTime("2013-12-31T22:59:21+01:00",ch2);

    System.out.println(dt);
    System.out.println(dt2);

    boolean b = dt.equals(dt2);

    System.out.println(b);