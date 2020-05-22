int count = 0;     
   while (true) {
       int a = 0;
       while(true) {
           System.out.print("Enter an integer between 10 and 100:");
           a = Integer.parseInt(sc.nextLine());
           if (a < 10 || a > 100)
              System.out.println("Invalid input\n");
           else
              break;
       }  
       // count++;
       // if (count == 5) if you break here, the code below won't be reached
       //   break;        thus you will never store the last user input 

       // Lists have a method contains that does exactly what you are trying to do
       // Consider using ifExists = userInput.contains(a)
       boolean ifExists = false;             
       for(int i = 0; i<userInputs.size(); i++) {
          if (userInputs.get(i) == a) {
             ifExists = true;
             break;

          }
       }
       if (!ifExists){
          System.out.printf("This is the first time %d has been entered\n", a);
          userInputs.add(a);
       }      
        // consider breaking here after you have collected the last user input
        // alternatively, use a do{ ... } while(); loop
        count++;
        if (count == 5)
            break;
   } // end while statement