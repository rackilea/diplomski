value = occurs(searchValues, numbers);
    System.out.println(searchValues + " occurs " + value + " time(s)");
    if (value > 0) {
        position = firstPosition(searchValues, numbers);

        System.out.println("The first occurence" + " is at position " + (position + 1));
    }