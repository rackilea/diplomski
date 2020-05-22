// COUNT BACKWARDS NOW. YOU WANT LARGEST ROW FIRST, OTHERWISE IT'S OK EXCEPT...
        for (j=numOfRows-1; j>=0 ; j-- ) 
        {
                for(k=numOfRows*2; k>1+j*2; k--)
                        System.out.print(" ");

                System.out.print("\\_"); // BORDERS ARE BACKWARDS. PUT BORDER ON OTHER SIDE
                for (i=0; i< 2+j*4; i++)
                {
                        if(j >= numOfRows/2 && (i>j*2- numOfRows/2 && i<j*2+ numOfRows/2)) {
                                System.out.print("*");                                 
                        }
                        else
                                System.out.print(".");
                }
                System.out.println("_/"); // PUT BORDER ON OTHER SIDE
        }

        for(i=0;i<numOfRows*2 +2;i++)
                System.out.print(" ");
        System.out.println("-");