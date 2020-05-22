public int swapNum(int num){
    int temp = 0;
    for(int i=0; i<numbers.length; i++) 
         if(numbers[i] == smallNum){ //find smallest value in array.
             temp = numbers[i];
             numbers[i] = num;
         }
     }
     return temp; //You can return the value that was swapped
}