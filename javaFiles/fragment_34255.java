String stringOfInts = "1,2,3,4,5";
    List<Integer> integers = new ArrayList<>();
    String[] splittedStringOfInts = stringOfInts.split(",");
    for(String strInt : splittedStringOfInts) {
        integers.add(Integer.parseInt(strInt));
    }

    // do something with integers