for (int h = 0; h < level; h++) {
            stars = 1;    
            for (int i = 0; i < height; i++){
                for (int j = szelesseg; j>i; j-- ) {
                    System.out.print(" ");
                }
                for (int k = 0; k < stars; k++){
                    System.out.print("*");
                }
                stars += 2;
                System.out.println();
           }
       }