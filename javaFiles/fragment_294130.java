//Declare variables
    int [] list = new int [6];
    int num = 0;
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    int max = Integer.MIN_VALUE;

    //While loop to store in array
    while (num<=5){
        list [num]=input.nextInt();
        num++;
    }

    for (int i = 0; i < num; i++) {
        if (list[i] > max){
           max = list[i];
        }
     }

    //Print out max value
    System.out.print("The max value is " + max + " ");
    input.close();