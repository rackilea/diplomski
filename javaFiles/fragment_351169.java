final ArrayList<String> testArrayList = new ArrayList<String>(1000);

    for (int i = 0; i < 1000; i++) {
        testArrayList.add(String.valueOf(i<<2));
    }

    final TimingLogger timings = new TimingLogger("Loop", "ArrayLists");

    timings.addSplit("start");

    for (int loopCount = 0; loopCount < 1000; loopCount++) {
        int sum = 0;

        for (int i = 0; i < testArrayList.size(); i++) {
            sum += Integer.valueOf(testArrayList.get(i));
        }
    }

    timings.addSplit("zero()");

    for (int loopCount = 0; loopCount < 1000; loopCount++) {
        int sum = 0;
        final int len = testArrayList.size();

        for (int i = 0; i < len; i++) {
            sum += Integer.valueOf(testArrayList.get(i));
        }
    }

    timings.addSplit("one()");

    for (int loopCount = 0; loopCount < 1000; loopCount++) {
        int sum = 0;

        for (String item : testArrayList) {
            sum += Integer.valueOf(item);
        }
    }

    timings.addSplit("two()");
    timings.dumpToLog();