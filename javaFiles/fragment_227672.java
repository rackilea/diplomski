int ar[][] = new int[4][4];
    System.out.println("Enter Numbers");
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            boolean flag = false;
            int num = sc.nextInt();
            if (num > 16 || num < 1) {
                System.out.println("Please Enter number between 1 to 16");
                flag=true;
                j--;

            } else {
                for (int k = 0; k <= i; k++) {
                    for (int l = 0; l <= j; l++) {
                        if (ar[k][l] == num) {
                            System.out.println("This number already inserted...Please give another");
                            j--;
                            flag = true;
                        }

                    }
                }
            }
            if (!flag) {
                ar[i][j] = num;
            }
        }
    }