Map<String, String> collect2 = 
    dataMap.entrySet()
          .stream()
          .map(e -> elements.stream()
                            // this will search for the first element of the List matching
                            // the value of the current Entry, if exists
                            .filter(el -> el.getField().startsWith(e.getValue()))
                            .findFirst()
                            // this will create a new Entry having the original key and the
                            // value obtained from the List
                            .map(el -> new SimpleEntry<>(e.getKey(),el.getField()))
                            // if findFirst found nothing, map to a null element
                            .orElse(null))
          .filter(Objects::nonNull) // filter out all the nulls
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));