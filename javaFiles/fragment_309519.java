int count = 0;
//Printing upper half of the diamond
for (int i = noOfRows; i >= 0; i-=2) {
    //Printing i spaces at the beginning of each row
    for (int j = 1; j <= i-md; j++) {
        if(i-md==0) {
            break;
        }
        System.out.print(" ");
    }
    //Printing j *'s at the end of each row
    for (int j = noOfRows - count; j <= (noOfRows+1-md); j++) {
        if (i-md==0 && j==midRow+1) {
            System.out.print("o ");
        }
        else {
           System.out.print("* ");
        }
    }
    System.out.println();
    count += 2;
}

//Printing lower half of the diamond
count = 0;
for (int i = 2; i <= noOfRows; i+=2) {
    //Printing i spaces at the beginning of each row
    for (int j = 1; j <= i; j++) {
        System.out.print(" ");
        count = j+1;
    }
    //Printing j *'s at the end of each row
    for (int j = count; j <= (noOfRows); j++) {
        System.out.print("* ");
    }
    System.out.println();
}