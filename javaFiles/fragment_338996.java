public static int[][] replaceValue(int target, int[][] currArray){
        int[][] temp = new int[currArray.length][];

        //get a boolean array of same size
        //NOTE: it is initialized as false
        boolean[][] needsChange = new boolean[currArray.length][currArray[0].length];

        //copy the current array into temp
        for(int i = 0; i < currArray.length; i++){
            temp[i] = currArray[i].clone();
        }

        //Go through each value in the 2d array
        for(int i = 0; i < temp.length; i++){
            for(int j = 0; j < temp[0].length; j++){
                //if it is the target value, mark it to be changed
                if(temp[i][j] == target){
                    needsChange[i][j] = true;
                }
            }
        }

        //Go through each value in the 2d array
        for(int i = 0; i < temp.length; i++){
            for(int j = 0; j < temp[0].length; j++){
                if(needsChange[i][j]){ //NOTE: same as "needsChange[i][j] = true;"
                    //Now, we will check to make sure we don't go out of bounds
                    //Top
                    if(i > 0){
                        temp[i-1][j] = target;
                    }

                    //Bottom
                    if(i + 1 < temp.length){
                        temp[i+1][j] = target;
                    }

                    //Left
                    if(j > 0){
                        temp[i][j-1] = target;
                    }

                    //Right
                    if(j + 1 < temp[0].length){
                        temp[i][j+1] = target;
                    }
                }
            }
        }

        //return the new array we made
        return temp;
    }