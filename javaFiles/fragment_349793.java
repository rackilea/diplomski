if ((t == 41) || (t == 42) || (t == 43)){
    System.out.println("Hit - Destroyer");
    area[i][j] = "X";
}
if ((t == 80) || (t == 90) || (t == 100)){
    System.out.println("Hit - Submarine");
    area[i][j] = "X";
}
if((t == 52) || (t == 62) || (t== 72) || (t == 82) || (t == 92)){
    System.out.println ("Hit - Aircraft Carrier");
    area[i][j] = "X";
}

if((t == 15) || (t == 16) || (t == 17) || (t == 18)){
    System.out.println ("Hit - Battleship");
    area[i][j] = "X";
}
if((t == 1) || (t == 2)){
    System.out.println ("Hit - PT Boat");
    area[i][j] = "X";
}
else{
    System.out.println ("Miss");
    area[i][j] = "O";
}