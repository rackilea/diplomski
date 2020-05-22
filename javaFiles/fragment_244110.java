List<Integer> numList = new ArrayList<Integer>();
   int number = 0;
   while (number != -1) {
      System.out.println("Enter a positive integer value (or -1 to stop): ");
      number = Integer.parseInt(in.nextLine());
      if (number != -1){
        numList.add(number);
      }
   }
   in.close();

   Integer[] numArray = numList.toArray(new Integer[numList.size()]);