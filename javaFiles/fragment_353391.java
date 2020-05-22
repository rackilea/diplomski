Scanner input_odd = new Scanner(System.in);
   int odd = 0; 

   while (odd % 2 != 1) {  // fails first time && if user enters even number
       System.out.println("Enter an odd number");
       odd = input_odd.nextInt(); 
   }