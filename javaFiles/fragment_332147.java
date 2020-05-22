public static boolean fillWithValues(Double[] array, Scanner scan) {
    int numberOfElements = 0;
    while(scan.hasNextDouble()){
        if(numberOfElements<array.length){
            array[numberOfElements] = scan.nextDouble();
            numberOfElements++;
        }else{
            return true;  // all elements read
        }
    }
    return false;   // input aborted
}