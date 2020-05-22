int weapon = 0;
   do{
       System.out.println("Pick number 1, 2, or 3.");
       if(scan.hasNextInt()){
           weapon = scan.nextInt();
           break;
       }else{
           System.out.println("Enter an integer only");
           scan.nextLine();
       }
   }while(true);