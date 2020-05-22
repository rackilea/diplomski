public static void main(String[] args) {

        int LARGE = 0;
        int Count = 0;
        String s = null;
        Scanner sc = new Scanner(System.in);
        do {

            LARGE = sc.nextInt();
            Count = sc.nextInt();

            if (LARGE == Count) {
                System.out.println("Large is Equal to Count");
            } else {
                do {
                    LARGE++;
                    System.out.println("Large is " + LARGE);
                } while (Count != LARGE);

                if (LARGE == Count) {
                    System.out.println("Large is Equal to Count");
                    System.out.println("Input a new integer to compare");
                }

            }

            System.out.println("Do you want to continue? If yes then Press Y");
            s = sc.next();
        } while (s.equalsIgnoreCase("Y"));

    }