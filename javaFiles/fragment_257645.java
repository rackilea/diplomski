public static int[] removeElementAt(int [] array, int index){
    if(index > 0 && index < array.length){
        int [] newArray = new int[array.length - 1];
        for(int i=0; i<index; i++)
            newArray[i] = array[i]; // copying elements
        for(int i=index+1; i<array.length; i++)
            newArray[i-1] = array[i];
        array = newArray;
    }
    return array;
}