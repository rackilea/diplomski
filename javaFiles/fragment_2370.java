Integer number = 1953824;
    Integer numberA = number;

    for (Integer numberC = number; numberC.toString().length() < 11; 
                    numberC = numberC + number) {

        Integer[] digitArray = new Integer[numberC.toString().length()];
        numberA = numberC;
        int index;
        for (index = 0; index < digitArray.length; index++) {
            digitArray[index] = (numberA % 10);
            numberA /= 10;
        }
        int repeats = 0;
        for (int i = 0; i < digitArray.length; i++) {
            for (int j = 0; j < digitArray.length; j++) {
                if ((i != j) && (digitArray[i] == digitArray[j]))
                    repeats = repeats + 1;
            }
        }
        if (repeats == 0) {
            System.out.println(numberC);
        }
    }