for(int i=0; i<asciLength; i++) {
    if (arr1[i] > arr2[i]) {
        System.out.println("Not In Lexicographic Order");
        return;
    } else if (arr1[i] < arr2[i]) {
        System.out.println("In Lexicographic Order");
        return;
    }
}
// at this point we know that the Strings are either equal or one 
// is fully contained in the other. The shorter String must come first
if (arr1.length <= arr2.length) {
    System.out.println("In Lexicographic Order");
} else {
    System.out.println("Not In Lexicographic Order");
}