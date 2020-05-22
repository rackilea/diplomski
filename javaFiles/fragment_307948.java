List<String> names = 
         // give the set of entries as a Stream.
         auto.entrySet().stream()
        // sort these entries, using the field returned by getValue()
        .sorted(Comparator.comparing(Map.Entry::getValue))
        // now sorted, turn each Entry into just the getKey()
        .map(Map.Entry::getKey)
        // now we have a stream of keys, turn this into a List<String>
        .collect(Collectors.toList());