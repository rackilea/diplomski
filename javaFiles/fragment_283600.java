public static int play(int[] a, int index, int sum){
    if (index>=a.length) return Integer.MAX_VALUE;  //Path went over last index. Invalid Path. 
    sum += a[index];  //Add on to the sum of the index you are currently on
    if (index == a.length-1){
        return sum;  //If we are at last element, return sum of the path traveled
    }else{
        return Math.min(play(a, index+1, sum), play(a, index+2, sum)); //Continue onto path checking both options
    }
}