for (Entry<String, HashMap<String, String>> entry:  hashMapOfMaps.entrySet()) {
        listOfLists.add(new ArrayList<String>(entry.getValue().values()));
    }                                                 |            |
                                                   inner-Map       |
                                                                   |
                                                      inner-Map's string values