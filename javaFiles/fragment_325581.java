int j = 0;
        while (j < 10) { 


            int i = j;
            while (i < 10) {


                if (i == j) {

                    int k = 0;
                    while(k < j) {

                        System.out.print("  ");
                        k++;
                    }   
                }
                System.out.print(" " + i);
                i++;
            }
            System.out.println();
            j++;
        }