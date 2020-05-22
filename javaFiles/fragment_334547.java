public static int radixToShift(int radix){
    int shift = 0;
    for(int i=0;radix >> i >1;i++){
        shift++;
    }
    return shift;
}