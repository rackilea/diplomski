public void add(E value) {
    int newsize=size+1;
    if(newsize<size){
        //The array is big enough, add the element
        array[newsize]=value;
    }else{
        //The array is too small, create a new one with
        //the old content but twice as bigger and add 
        //the new element
        array=Arrays.copyOf(array,size*2); 
        array[newsize]=value;  
    }
    size=newsize;
}