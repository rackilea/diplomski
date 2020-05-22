// create an arraylist
        List<int[]> arrList = new ArrayList<>();

        // populate an arraylist
        arrList.add(new int[] { 1, 2 });
        arrList.add(new int[] { 4, 5 });

        // print arraylist before changing
        System.out.println("The value before changing: " + arrList.get(0)[0]); // prints
                                                                                // 1

        arrList.get(0)[0] = 9;
        System.out.println("The value after changing: " + arrList.get(0)[0]); // prints
        // This is what I have come up with.
        // the loop changes the values of the first array in a given arraylist
        int[] is = arrList.get(0);
        for (int i = 0; i < is.length; i++) {
            is[i] = i * i;
        }

        // print arraylist after changing
        System.out.println("The value after changing: " + arrList.get(0)[0]); // prints
                                                                                // 9