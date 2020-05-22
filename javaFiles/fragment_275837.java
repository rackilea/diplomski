public static void main(String[] args) {

        // Moved this outside the while loop as davidxxx pointed out +1
        Scanner s = new Scanner(System.in);


        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Addition");
            System.out.println("2. Substraction");
            System.out.println("3. Multipication");
            System.out.println("4. Division");
            System.out.println("Enter your choice: ");
            int i = s.nextInt();

            System.out.println("ENTER FIRST NUMBER ");
            int a = s.nextInt();

            System.out.println("ENTER SECOND NUMBER ");
            int b = s.nextInt();

            int result = 0;//'result' will store the result of operation

            switch (i) {
                case 1:
                    result = a + b;
                    break;
                case 2:
                    result = a - b;
                    break;
                case 3:
                    result = a * b;
                    break;
                case 4:
                    result = a / b;
                    break;

                default:
                    System.out.println("Wrong Choice.");

            }

            System.out.println("Answer is " + result);

            System.out.println("Go again?");
            String goAgain = s.next();
            if (!goAgain.equals("y")) {
               break;
            } 

        }
    }