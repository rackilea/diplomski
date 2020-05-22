void reverseArray(int[] x){
   reverse(x, 0, x.length -1);
}

void reverse(int[] x, int i, int j){
    if(i<j){//Swap ith with jth element where i and j are equidistant from ends
       int tmp = x[i];
       x[i] = x[j];
       x[j] = tmp;
       reverse(x, ++i, --j);//Recursive
    }   
}