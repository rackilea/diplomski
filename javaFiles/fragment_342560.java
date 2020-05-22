for (Entry<Character, Map<Integer, Double>> outer : MapInsideOfAMap.entrySet()) {
        System.out.println("Char: " + outer.getKey() + "\n");

        for (Entry<Integer, Double> inner : outer.getValue().entrySet()) {
            System.out.println("int = " + inner.getKey() + ", double = " + inner.getValue());
        }
    }