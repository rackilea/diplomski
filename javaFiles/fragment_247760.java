public void iterateHashMap(Map<Dog, List<String>> mapOfDogsAndDescriptions){
    int count = Integer.parseInt(System.getProperty("count"));
    for (Map.Entry<Dog, List<String>> entry : mapOfDogIdsAndStrings.entrySet()) {
        if (count-- <= 0)
            break;
        String key = entry.getKey().getId();
        List<String> StringList = entry.getValue();

        //do something
    }

}