public static void method2(Integer[] numbers, Integer barrier) {
    int highNumbers = 0;
    int lowNumbers = 0;

    for (Integer i : numbers) {
        if (i > barrier) {
            highNumbers++;
        } else {
            lowNumbers++;
        }
    }

    Integer[] highArray = new Integer[highNumbers];
    Integer[] lowArray = new Integer[lowNumbers];
    Integer highArrayIndex = 0;
    Integer lowArrayIndex = 0;

    for (Integer i : numbers) {
        if (i > barrier) {
            highArray[highArrayIndex] = i;
            highArrayIndex++;
        } else {
            lowArray[lowArrayIndex] = i;
            lowArrayIndex++;
        }
    }

    for (Integer i : highArray) {
        System.out.println("Higher: " + i);
    }

    for (Integer i : lowArray) {
        System.out.println("Lower: " + i);
    }
}