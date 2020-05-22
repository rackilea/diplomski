public static void method1(Integer[] numbers, Integer barrier) {
    List<Integer> high = new ArrayList<Integer>();
    List<Integer> low = new ArrayList<Integer>();

    for (Integer i : numbers) {
        if (i > barrier) {
            high.add(i);
        } else {
            low.add(i);
        }
    }

    for (Integer i : high) {
        System.out.println("Higher: " + i);
    }

    for (Integer i : low) {
        System.out.println("Lower: " + i);
    }
}