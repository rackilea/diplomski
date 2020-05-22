for (int i = 0; i < 1000; ++i) {
        colorsSet.add("" + i);
    }

    for (int i = 0; i < 1000; ++i) {
        colorsSet.remove("" + i);
    }   


    System.out.println(colorsSet); // [blue, red, green, orange]