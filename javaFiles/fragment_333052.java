int count = 0;
    double input = 0.334;
    for (int i = 0; i < array.length; i++) {
        if (array[i] == input)
            ++count;
    }

    System.out.println(count);