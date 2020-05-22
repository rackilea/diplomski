for ( int i = 1 ; i <=6 ; i++ ){
            for( int j = 0 ; j <= 20 - i ; j++ ){
                System.out.print(" ");
            }
            int k = i ;
            while (k > 0){
                System.out.print(i);
                k--;
            }
            System.out.println("");
        }