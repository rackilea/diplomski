String[][] tArray=new String[2][4];

    for (int row=0; row<2;row++){

        for (int col=0,count=0;col<4;col++ ,count++){
            Scanner input=new Scanner(System.in);
            System.out.print("Please Enter the name " +count+ ":");
            tArray[row][col]=input.next();
        }

    }

    for (int row=0; row<2;row++){

        for (int col=0;col<4;col++){
            System.out.println(tArray[row][col]);
        }

    }