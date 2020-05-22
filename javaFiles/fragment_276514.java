Integer num = 1;
    numberToPrint(endNum, num);
}

public static int numberToPrint(int endNum, int num) {
    System.out.print(num + ", ");
    if (num >= endNum) {
        return num;
    } 
    return numberToPrint(endNum, (num + 1));
}