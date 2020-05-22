int todash = 3;
            System.out.print("The Phone number is     : ");
            for (int i=0; i < number.length; ++i) {
                    if (todash == 0) {
                            System.out.print("-");
                            todash = 4;
                    }
                    System.out.print(number[i]);
                    --todash;
            }
            System.out.println("");