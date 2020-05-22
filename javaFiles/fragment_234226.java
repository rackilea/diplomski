public void nextFree(String seats) {
    int colA = 0;
    int rowA = Integer.parseInt(seats.substring(1, 2));
    int newColB = 0;
    int newRowB = 0;
    int distance = -1;
    //Would recommend changing this to a switch statement, might lake it clearer
    if (seats.equalsIgnoreCase("a")) {
        colA = 1;
    } else if (seats.equalsIgnoreCase("b")) {
        colA = 2;
    } else if (seats.equalsIgnoreCase("c")) {
        colA = 3;
    } else {
        colA = 4;
    }

    for (int i = 0; i < table.length; i++) {
        for (int k = 0; k < table[i].length; k++){
            //Calculating current distance away from our chair
            //This assumes i is the column and k is the row, you may need to swap those values around
            int curDistance = Math.abs(i-colA) + Math.abs(k-rowA);
            //If the seat is free and the distance hasn't been set or the current distance is less than the previous distance
            if (table[i][k].equals("--") && (distance == -1 || distance > curDistance) {
                //Found a closer seat
                newRowB = k;
                newColB = i;
                distance = curDistance;
            }
        }
    }
    //Moved this out the for loop, it shouldn't have been inside
    System.out.print("The seat " + colA + rowA + " is not available! The next availale is " + newColB + newRowB);
}