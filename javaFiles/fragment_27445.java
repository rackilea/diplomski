public static void multBy2IfOneThirdIsPresent(Fraction[] arr){
    if(oneThirdIsPresent(arr)){
        recursivelyMultBy2(arr, 0);
    }else{
        return;
    }
}