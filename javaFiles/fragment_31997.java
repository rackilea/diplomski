String[][] tests = {
        { "1", "" },
        { "123", "" },
        { "this", "that" },
        { "tit", "tat" },
        { "word", "sword" },
        { "desert", "dessert" },
        { "lulz", "lul" },
        { "same", "same" },
    };
    for (String[] test : tests) {
        System.out.printf("[%s|%s] = %s%n",
            test[0], test[1], oneEdit(test[0], test[1])
        );
    }