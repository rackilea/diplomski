public static void main(String args[]) {
       Scanner input = new Scanner(System.in);
       double total = 10.00;
       System.out.println("Do you require the tickets to be posted?\n(£2.34 for post and packing for the entire order)\n(please enter 'Yes' on the next line if you require postage)");

       if ("Yes".equalsIgnoreCase(input.next())) {
          System.out.println("Postage will be added to your cost");
          total = total + 2.34;
       } else
          System.out.println("Postage will not be added to your cost");
   }