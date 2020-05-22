for (int a=1; a < 5; a++) {
            for (int b=1; b < 5; b++) {
                if (a == b) {
                    System.out.println("pair found   " + a + "    " + b);
                    b = 5;
                    a = 5;
               }
           }
       }