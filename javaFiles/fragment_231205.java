public int sumAll(int...numbers){

    int result = 0;
    for(int i = 0 ; i < numbers.length; i++) {
        result += numbers[i];
    } 
    return result;
}