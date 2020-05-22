String[] innerRotorClockWise = new String[]{"#", "G", "N", "U", "A", "H"};
    int innerLastIndex = innerRotorClockWise.length - 1;

    String innerOldLast = innerRotorClockWise[innerLastIndex];

    for (int i = innerLastIndex; i != 0; i--) {


        innerRotorClockWise[i] = innerRotorClockWise[i - 1];

    }
    innerRotorClockWise[0] = innerOldLast;
    System.out.println(Arrays.toString(innerRotorClockWise));