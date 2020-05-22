int occupiedSpots = 0;
Random random = new Random();

while(occupiedSpots < 8){
    int x = random.nextInt(array.length);
    int y = random.nextInt(array[0].length);
    if(battleship[x][y] == 0){
        battleship[x][y] = 1;
        occupiedSpots++;
    }
}