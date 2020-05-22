int i[] = {2,5,4,23,7,2,4,2};
        int occurnce = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number :");
        int number = s.nextInt();
       for (int n=0;n<i.length;n++){
           if(i[n] == number)
               occurnce++;
      }
       if(occurnce>0)
        System.out.println("Number of occurance : " +occurnce);
       else
        System.out.println("Number doesnt exist");