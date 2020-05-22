divisor = kb.nextInt();  // gets your divisor
            while (divisor == 0)  //if it is illegal, e.g. 0
            {
                System.out.println("\nYou can't divide by 0. Try again!: ");
                divisor = kb.nextInt(); // waits for more divisor input
            }