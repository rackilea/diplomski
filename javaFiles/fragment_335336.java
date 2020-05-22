Timestamp t1 = new Timestamp (0);
    Timestamp t3 = new Timestamp (999);
    Timestamp t4 = new Timestamp (5001);
    // Careful here; internally, Java has set nanos already!
    t4.setNanos (t4.getNanos () + 1);

    // Show what a mess this API is...
    // Yes, the milliseconds show up in *both* fields! Isn't that fun?
    assertEquals (999, t3.getTime ());
    assertEquals (999000000, t3.getNanos ());
    // This looks weird but t4 contains 5 seconds, 1 milli, 1 nano.
    // The lone milli is in both results ...
    assertEquals (5001, t4.getTime ());
    assertEquals (1000001, t4.getNanos ());

    diff = DBUtil.diff (t1, t4);
    assertEquals (5001, diff.getTime ());
    assertEquals (1000001, diff.getNanos ());

    diff = DBUtil.diff (t4, t3);
    assertEquals (4002, diff.getTime ());
    assertEquals (2000001, diff.getNanos ());