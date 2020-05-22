public byte getLive(int x, int y) {
    return board.get(y).get(x);
}

public void patternRight(){
    List<List<Byte>> testBoard = new ArrayList<>();
    for (int y = 0; y < getHeight(); y++) {
        List<Byte> row = new ArrayList<>();
        for (int x = 0; x < getWidth(); x++)
            row.add((byte) 0);
        testBoard.add(row);
    }
    for (int x = 0; x < getWidth(); x++) {
        for (int y = 0; y < getHeight(); y++) {
            if (getLive(x, y) == 1)
                testBoard.get((y + movedistance) % getHeight()).set(x, (byte) 1);
        }
    }
}