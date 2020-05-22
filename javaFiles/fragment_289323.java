if (!positionCost.containsKey(position)) {
    positionCost.put(position, newcost);
} else {
    // the key already exists in the map. It might be a bug, or it might be 
    // a valid situation that you have to decide how to handle
}