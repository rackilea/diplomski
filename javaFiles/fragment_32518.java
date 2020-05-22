Scanner input = new Scanner(System.in);
    int magic_square[][]=new int[3][3];
    int counter = 0;
    System.out.println("Enter the Magic Number: ");
    while(counter < 9){
      System.out.println("Number "+(counter+1));
      int input_num = input.nextInt();
      if (input_num < 1 || input_num > 9){
         System.out.println("ERROR! Input range is invalid.");
       } else {
          magic_square[counter/3][counter%3] = input_num;
          counter++;
       }
    }