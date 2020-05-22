List<List<String>> tempPlaces = new ArrayList<List<String>>();
    String[] string1 = new String[]{"a", "b", "c"};
    String[] string2 = new String[]{"aa", "bb", "cc"};
    tempPlaces.add(Arrays.asList(string1));
    tempPlaces.add(Arrays.asList(string2));

    List<List<String>> places = new ArrayList<List<String>>();
    places.addAll(tempPlaces);