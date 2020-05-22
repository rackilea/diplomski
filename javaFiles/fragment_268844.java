public void getMultiplicationTable(){

      Scanner numsEnter = new Scanner(System.in);

    System.out.println("Please enter in two numbers: ");

    int numRow = numsEnter.nextInt();
    int numCol = numsEnter.nextInt();

    int[][] table = new int[numRow+1][numCol+1];

    System.out.println("Please enter in two numbers: ");

    while(true){
        if((numRow >= 1 && numRow <= 10) && (numCol >= 1 && numCol <= 10)){
            break;
        }else{
            System.out.println("These numbers are invalid, please enter two numbers between 0 & 10");
            numRow = numsEnter.nextInt();
            numCol = numsEnter.nextInt();
        }
    }

    numRow++;
    numCol++;

    for(int row=0; row < table.length; row++){
        for(int column = 0; column < table[row].length; column++){
            System.out.print(table [row] [column] = (row) * (column) );
            System.out.print(" ");
        }
        System.out.println();
    }

    }