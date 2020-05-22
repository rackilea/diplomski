System.out.println("\nPlease enter the integer your output should be divisible by: ");
            divisor = kb.nextInt();  // gets your divisor
            while (divisor == 0)  //if it is illegal, e.g. 0
            {
                divisor = kb.nextInt(); // waits for more divisor input
            }