public void applyToAll(Action<MyObject> action) {
    for(int y = 0; y < height; y++) {
        for(int x = 0; x < width; x++) {
            action(table[y][x]);
        }
    }
}