public static void main(String[] args) {
      final int totalPoints = 4;
      Random r = new Random();
      in = new Scanner(System.in);

      ArrayList<Integer> poops = new ArrayList<Integer>(totalPoints);
      ArrayList<Integer> userinputs = new ArrayList<Integer>(totalPoints);

      for (int i=0; i<totalPoints; i++) {
          int poop = (r.nextInt(10-1)+1);
          System.out.println("Random datapoints: " + poop);
          poops.add(poop);
      }


      System.out.println("Enter a number from 1-9");
      for (int i=0; i<totalPoints; i++) {
          int s = in.nextInt();
          userinputs.add(s);
      }

      int correct = 0;
      for (int i=0; i<4; i++) {
          if (poops.contains(userinputs.get(i))) {
              correct++;
          }
      }

      System.out.println("You have " + correct + "correct numbers");

}