String input = sc.nextLine();

  for (int i=0; i<=15; i++) {            
    if(input.charAt(0) == '4')
        System.out.println("Your Card is a Visa Card");
    else if (input.charAt(0)=='5')
         System.out.println("Your Card is a Master Card");
    else if (input.charAt(0) =='3' && input.charAt(1)=='7')
         System.out.println("Your Card is American_Express");
    else if (input.charAt(0) =='6')
         System.out.println("Your Card is a Discover Card");
    else
         System.out.println("Your Card is unknown");
  }