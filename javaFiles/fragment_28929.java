if (flowerFrequency.containsKey(aFlower)) {
            Integer i = flowerFrequency.get(aFlower); //uses two lookups
            i++; //only increments our immediate value, not the object
        } else {
            flowerFrequency.put(aFlower, new Integer(1)); //does not need wrapping
        }