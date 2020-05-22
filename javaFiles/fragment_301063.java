public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);
        System.out.println();
        System.out.print(" Welcome! Please enter the number of figures for your totem pole: ");

        while (!stdin.hasNextInt()) {
            System.out.print("That's not a number! Please enter a number: ");
            stdin.next();
        }

        int figureNumber = stdin.nextInt();
        eagle();
        if (figureNumber % 2 == 0) { //determines if input number of figures is even
            figureNumber -= 1;
        }
        for (int i = 1; i <= (figureNumber / 2); i++) {
            whale();
            human();
        }
    }