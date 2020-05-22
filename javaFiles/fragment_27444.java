private static boolean oneThirdIsPresent(Fraction[] arr){
    for (int i = 0; i < arr.length; i++) {
        if(arr[i].numerator == 1 && arr[i].denominator == 3) {
            return true;
        }
    }
    return false;
}

private static void recursivelyMultBy2(Fraction[] arr, int index){
    if(index == arr.length){
        return;
    }
    arr[index] = arr[index].multiplyBy(new Fraction(2));
    recursivelyMultBy2(arr, index+1);
}