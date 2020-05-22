animalMap.entrySet().stream()
        .forEach(
                pair -> {
                    if (pair.getValue() != null) {
                        myMap.put(pair.getKey(), pair.getValue());
                    } else {
                        myList.add(pair.getKey());
                    }
                }
        );