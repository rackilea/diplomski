String input = sc.nextLine();
  int[] CC =new int[16];

   for (int i=0;i<=15;i++) {
       Count++;
       CC[i]= Character.getNumericValue(input.charAt(i));
    }