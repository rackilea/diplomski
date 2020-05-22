do {
        System.out.println("How Old Are you:");
        Num = input.nextLine();
        if (Num.isEmpty()){
            System.out.println("Number field should not be Empty.");
            break;       
        }
        else if (!Num.matches(regex1)){
            System.out.println("Please Enter A Valid Number!");
            break;
        }
        else{
            if(Integer.parseInt(NUM)<18){
               System.out.println("Underage, exiting");                
               break;
            }
            else
               System.out.println("You Are"+" "+Num);
        }     
    }while(!Num.matches(regex1));