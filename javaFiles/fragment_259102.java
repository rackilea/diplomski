Set<Integer> set = new TreeSet<Integer>();
    while (inputFile.hasNextInt()) {
        int value = inputFile.nextInt();
        if (set.contains(value)) {
            // save value to dublicate's file
        }
        set.add(value);
    }
    Integer[] numbersInteger = set.toArray(new Integer[set.size()]);