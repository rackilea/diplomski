int secondArray[] = { 0, 1, 5, 2 };
    int num;

    for (int i = 0; i < secondArray.length - 1; i++) {
        for (int j = 0; j < secondArray.length - 1 - i; j++) {
            if (secondArray[j] > secondArray[j + 1]) {
                num = secondArray[j];
                secondArray[j] = secondArray[j+1];
                secondArray[j+1] = num;
            }
        }
    }
    for(int number : secondArray){
        System.out.print(number);
    }