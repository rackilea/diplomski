public static void userInput(){
        Scanner scan = new Scanner(System.in);
        int x = 1;
        int month, day, year;

        System.out.println("Please enter a month MM: ");
        month = scan.nextInt();
        boolean i = true;
        while(i == true)
        {
            if(month < 12 && month > 1)
            {
                System.out.println("FLOP");
                i = false;
            }
            else if(month >= 12 || month <= 1)
            {
                System.out.println("not today mate");
                month = scan.nextInt();                
            }
        }     

  }