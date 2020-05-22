public static void main(String[] args)
   {

      final float PRICEDOZEN = 3.25f;
      final float PRICELOOSE = .45f;
      Scanner inputDevice = new Scanner(System.in);
      System.out.println("How many eggs are you ordering? \nPRICELIST: \nONE DOZEN EGGS: $3.25 LOOSE EGGS: $0.45");
      int eggsInput = inputDevice.nextInt();

      int eggsDozen = eggsInput / 12;
      int eggsLoose = eggsInput % 12;
      boolean isDozen = eggsDozen >= 1;

      DecimalFormat dollars = new DecimalFormat("$0.00"); //now this format can be used throughout the main method

      if (isDozen == true) {
      System.out.println("That's " + eggsDozen + " dozen at $3.25 per dozen, and " + eggsLoose + " loose eggs at 45 cents each.");

      System.out.println("For a total of $" + (eggsDozen * PRICEDOZEN + eggsLoose * PRICELOOSE) + ".");
      }
      else {
      System.out.println("That's " + eggsLoose + " loose eggs at 45 cents each.");
      System.out.println("For a total of " + (dollars.format(eggsLoose * PRICELOOSE)) + ". Did you know we offer a discount on eggs ordered by the dozen?");
      }
   }