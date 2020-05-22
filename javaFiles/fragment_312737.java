boolean isConnected(List<Tile> selection) {

    if (selection.isEmpty())
        return true; // ?????

    Queue<Tile> toConsume = new LinkedList<>(selection);
    Queue<Tile> queue = new LinkedList<>();
    queue.add(toConsume.remove());

    while (!queue.isEmpty() && !toConsume.isEmpty()) {
        Tile tile = queue.remove();
        findNeighbours(tile, toConsume)
        .forEach(n -> {
            toConsume.remove(n);
            queue.add(n);
        });
    }
    return toConsume.isEmpty();
}

List<Tile> findNeighbours(Tile tile, Collection<Tile> tiles) {
    return tiles.stream()
        .filter(t -> distance(t, tile) == 1)
        .collect(Collectors.toList());
}

int distance(Tile a, Tile b) {
    int dx = a.getX() - b.getX();
    int dy = a.getY() - b.getY();
    return Math.abs(dx) + Math.abs(dy);
}