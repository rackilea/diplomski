for(int i = 0; i < arrayNumber.length; i++) {    
    arrayNumber[i] = i;
    int tmp = arrayNumber[i];

    // summing up digits
    while(tmp > 0) {
        arrayNumber[i] += tmp%10; //extracting right-most digit
        tmp /= 10; // removing the right-most digit
    }
    System.out.println(i , arrayNumber[i]);
}