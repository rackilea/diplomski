//For every Cell on the board
for (int i = 0; i < key.length; i++){
    for (int a = 0; a < key[0].length; a++){

        //If it Is not a mine
        if (key[i][a] == 0){ 
            int count = 0;

            //Position of cells around key[i][a] relative to key[i][a]
            for (int x = -1; x < 2; x++){  
                for (int y = -1; y < 2; y++){ 

                    //Storing x and y test points
                    int testX = i + x;//testX = i-1, i, and i+1
                    int testY = i + y;//testY = i-1, y, and y+1

                    //If the testX and testY values are within the range of the array
                    if ((testX >= 0 && testX < key[0].length) && testY >= 0 && testY < key.length){

                        //If there is a mine
                        if (key[testX][testY] == 9){
                            count++;
                        }
                    }
                }
            }

            key[i][a] = count;

            //count = 0; This is redundant. Line 7 count gets set to 0.
        }
    }
}