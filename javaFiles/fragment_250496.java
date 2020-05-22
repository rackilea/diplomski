public static void main(String[] args) {

    System.out.print("\t\t Stadium Seating \n");

    Seat seatArray[][]= new Seat[10][7];
    int i, x, y = 1;

    for(i = 0; i < 10; i++) {
        for(x = 0; x < 7; x++) {
            if(i >= 2 && i <= 7 && x >= 2 && x <= 4){
                seatArray[i][x] = new Seat(); //Not available seat
            } else {
                seatArray[i][x] = new Seat(y);
            }
            y++;
        }
    }

    for(Seat[] row : seatArray){ printRow(row); }
}
public static void printRow(Seat[] row) {
    for (Seat s : row) {

        System.out.print(s); //toString method called implicitly here.
        System.out.print(" \t");
    }

    System.out.println();
}