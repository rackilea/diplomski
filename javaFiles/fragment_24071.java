boolean  isSorted(float[] numbers, boolean ascending){
    //tell if the numbers are ascending (ascending == true), or not (ascending == false)
    boolean s=ascending;
    for(int i = 0; i < numbers.length; i++){
        //added this if condition to avoid ArrayIndexOutOfBoundsException
        if(i == numbers.length-1){
            continue;
        }
        s= numbers[i] < numbers[1+i];
    }
    return s;
}