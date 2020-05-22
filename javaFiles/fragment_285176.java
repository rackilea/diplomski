public static boolean findHorizontal(int[][] arr, int x, int y, int counter){
    //base case
    if(counter == 4)
        return true;

    if(arr[x][y] == 1)//consecutive 
        counter++
    else//not consecutive
        counter = 0;

    x++;

    //change this to handle wrap around case
    if(x == arr.length - 1)
        return false;

    return findHorizontal(arr, x, y, counter);
}