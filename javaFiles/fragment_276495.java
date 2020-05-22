public NaturalNumberTuple(int[] numbers) {
    int [] thisTuple = new int[numbers.length];
    int count = 0;
    for(int j = 0; j < numbers.length; j++){
        if(numbers[j] > 0){
            thisTuple[count] = numbers[j]; // changed thisTuple[j] to thisTuple[count]
            count++;
        }
    }
    int[] newTuple = new int[count];
    for(int i = 0; i < newTuple.length; i++) {
        newTuple[i] = thisTuple[i];
    }
    this.tuple = newTuple;
}