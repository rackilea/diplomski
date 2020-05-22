int dual_wedge_length=9;
    int height2 = (dual_wedge_length+1)/2;
    for(int i = 0;i < dual_wedge_length; i++)System.out.print("*");
    System.out.println();
    for(int i = 1; i < height2;i++){
        int num = height2 - i;
        for(int j = 0; j < num; j++){
            System.out.print("*");
        }
        for(int k = 0; k < 2*i -1; k++){
            System.out.print(" ");
        }
        for(int m = 0; m < num; m++){
            System.out.print("*");
        }
        System.out.println();

    }