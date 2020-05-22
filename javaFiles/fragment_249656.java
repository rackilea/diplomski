public void turn(int n){
    Direction[] directions = Direction.values()
    for (int i = 0; i < n; i++) {
        int direction_index = i % directions.length;
        Direction direction = directions[direction_index];
        // Do something with direction
    }
}