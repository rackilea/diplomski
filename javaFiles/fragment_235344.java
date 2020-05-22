public void searchArray(int[] myArr, int num){

    int counter = 0;

    //FOR-LOOP
    for(int i=0; i < myArr.length; i++){
        if(myArr[i] == num){
            counter++;
        }
    }

    int[] newArr = new int[counter];

    // SECOND FOR LOOP

    for(int i=0, j=0; i < myArr.length; i++){
        if(myArr[i] == num){
            newArr[j++] = i;
        }
    }

    // PRING OUT 'newArr' elements
    for(int value : newArr){

        System.out.printf(" %d ", value);
    }
}