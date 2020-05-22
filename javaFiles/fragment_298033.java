public class Ship {

    int shipLength = 3;
    int numRows = 5;

    int[] coord = new int[shipLength];
    public Ship() {
        coord[0] = (int) (Math.random() * numRows + 1);
        for (int i=1;i<shipLength;i++){
            coord[i] = coord[i-1] + 1;
        }
    }
    public void setCoord(int cell, int value){
        coord[cell] = value;
    }

    public int getCoord(int cell){
        return coord[cell];
    }
}