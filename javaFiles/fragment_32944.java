//this codes finds the first key whose value equals the desired value
Object key = tree.entrySet().stream()
                            .filter(e -> e.getValue().equals(desiredValue))
                            .map(Entry::getKey)
                            .findFirst()
                            .get();