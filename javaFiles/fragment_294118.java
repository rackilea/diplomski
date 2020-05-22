//create square with "o" everywhere then overwrite
int i = 0;
int j = 0;
while(i < height/2 || j < width/2){

    //go from all corners towards the middle
    if (i == j){
       square[i][j] = "x";
       square[i][width - j+1] = "x";
       square[height - i+1][j] = "x";
       square[height - i+1][width - j+1] = "x";
    } else if (i < height/2) { //i is in middle of array
       square[i][j] = "x";
       square[i][width - j+1] = "x";
    } else { //j is is in middle of array
       square[i][j] = "x";
       square[height - i+1][j] = "x";
    }

    //as long i and j did not reach the center add 1
    if (i < width/2) { i++ }
    if (j < height/2) { j++ }
}