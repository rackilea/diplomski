public static boolean findVertical(int[][] arr, int x, int y, int counter){
    //base case
    if(counter == 4)
        return true;

    if(arr[x][y] == 1)//consecutive 
        counter++
    else//not consecutive
        counter = 0;

    y++;

    //change this to handle wrap around case
    if(y == arr[x].length - 1)
        return false;

    return findVertical(arr, x, y, counter);
}