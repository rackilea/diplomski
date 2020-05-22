public int sqSum(){
    int sqSum =0;//declare it outside loop and use the same

    for(int i=0; i<array.length; i++)
       sqSum = sqSum + array[i] * array[i]; //add each product to previous sqSum

    return sqSum;
}