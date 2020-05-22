for (Entry<Character, Map<Integer, Double>> outer : MapInsideOfAMap.entrySet()) {
        System.out.println("Char: " + outer.getKey() + "\n");
        for (Entry<Integer, Double> inner : MapInsideOfAMap.get(outer.getKey()).entrySet()) {
            System.out.println("int = " + inner.getKey() + ", double = " + inner.getValue());
        }
    }