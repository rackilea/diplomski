public static void diamond3() {
System.out.println("Output for: Do while Loop");

    int noOfRows =5;
    int md=noOfRows%2;

    //Getting midRow of the diamond
    int midRow = (noOfRows)/2;      

    int i = noOfRows;

    do {
        //Printing i spaces at the beginning of each row

        int j = 1;
        do {
            if (i-md==0) break; 
            System.out.print(" ");
            j++;
    }
        while (j <= i-md);

        //Printing j *'s at the end of each row

        do {
            if (i-md==0 && j==midRow+1){
              System.out.print("o ");   
            } else {
              System.out.print("* ");
            }
            j++;
        }
        while (j <= (noOfRows+1-md));
        System.out.println();


        i=(i - 2);
    }  
    while (i >= 0); 

    i = 2;

    do {
        //Printing i spaces at the beginning of each row

        int j = 1;
        do {
              System.out.print(" ");
            j++;
        }
        while (j <= i);     

        do {
            System.out.print("* ");
            j++;
        }
        while (j <= (noOfRows+1-md));

        System.out.println();

        //Printing j *'s at the end of each row

        i=(i + 2);
    }  
    while (i <=noOfRows);
}