for(int i=0; i<array.length; i++){

    int firstNum = array[i];
    int secondNum = givenNum - firstNum;

    /* Now if it is possible to sum up two prime nums to result into given num, secondNum should also be prime and be inside array */

    if(ArrayUtils.contains(array, secondNum)){
        System.out.println("Yes, it is possible. Numbers are "+ firstNum + " and " + secondNum);
    }
}