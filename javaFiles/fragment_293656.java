List<Float> positions = new ArrayList<Float>();
    List<Integer> indexes = new ArrayList<Integer>();
    positions.add(0.1f);
    positions.add(0.8f);
    positions.add(0.3f);

    // copy float elements to another List, so to keep the order
    List<Float> sortedPositions = new ArrayList<Float>();
    Collections.copy(sortedPositions, positions);
    Collections.sort(sortedPositions);

    for (Float position : positions) {
        indexes.add(sortedPositions.indexOf(position));
    }

    for (Integer index : indexes) {
        System.out.print(index + ",");
    }
    // prints 1,3,2,