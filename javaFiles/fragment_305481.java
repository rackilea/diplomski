public String returnSeats(){
    StringBuilder result = new StringBuilder();
    for (int i =0; i <seats.length; i++){
        for (int j = 0; j < seats[i].length; j++){
            //append seat character in the result string
            result.append(seats[i][j]);
        }
        //append new line character in the string in between
        result.append(System.lineSeparator());
    }
    return result.toString();
}