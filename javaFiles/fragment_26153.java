ShannonsTheorem shannonsTheorem = new ShannonsTheorem();

    double expectedbandwith = 0.0;
    assertEquals(expectedbandwith , shannonsTheorem.getBandwidth(), 0);

    int expectedSignalToNoise = 0;
    assertEquals(expectedSignalToNoise  , shannonsTheorem.getSignalToNoise(), 0);

    int expectedMaximumDataRate = 0;
    assertEquals(expectedMaximumDataRate , shannonsTheorem.maxiumumDataRate(), 0);


    // ...