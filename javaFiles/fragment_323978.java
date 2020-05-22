int maxValue = Setting.NEGATIVE_INFINITY;
maxChildren = generateMoves(state);
for (State aChildren : maxChildren) {
    maxValue = Math.max(maxValue, MinTurn(aChildren)); // <-- A
    nodes.add(aChildren.getState() + " " + maxValue); // <--B
}