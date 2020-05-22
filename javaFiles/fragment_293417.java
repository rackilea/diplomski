public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double[][] maxtrix = new double[4][2];
        boolean areApplesEntered = false, areOrangesEntered = false;

        for (int i = 0; i < maxtrix.length; i++) {          
            areApplesEntered = false;
            areOrangesEntered = false;
            for (int j = 0; j < maxtrix[i].length; j++) {
                double apples, oranges;
                if (areApplesEntered == false) {
                    do {
                        System.out.println("Enter the # of apples between 1 and 20 for the bag ["+(i+1) +"] -->");
                        apples = input.nextDouble();

                    } while (apples < 1 || apples > 20);

                    maxtrix[i][j] = apples;
                    areApplesEntered = true;
                } else {

                    do {
                        System.out.println("Enter the # of oranges between 1 and 5 for the bag ["+(i+1)+"] -->");
                        oranges = input.nextDouble();

                    } while (oranges < 1 || oranges > 5);

                    maxtrix[i][j] = oranges;
                    areOrangesEntered = true;
                }

            }

        }

    }