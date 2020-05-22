animalMap.forEach(
            (key, value) -> {
                if (value != null) {
                    myMap.put(key, value);
                } else {
                    myList.add(key);
                }
            }
    );