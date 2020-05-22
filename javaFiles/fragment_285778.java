// if using jdk 1.7 or above else close scanner in finally block.
    try (Scanner s = new Scanner(System.in)) {

        int n;
        while (true) {
            n = s.nextInt();
            if (n < 0) {
                // ask for value greater then 0
                System.out.print("Please enter a value greater then 0 ");
                // extra print statement so input will be printed on next line after message
                System.out.println();
            } else if (n > 35) {
                // ask for value less then 35
                System.out.print("Please enter a value less then 35");
                System.out.println();
            } else {
                // process input and break if correct input has received
                calc(n);
                break;
            }
        }
    }