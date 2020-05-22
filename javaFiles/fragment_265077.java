Scanner sc = new Scanner(System.in);
        int x;
        do{
            try{
                x = Integer.parseInt(sc.nextLine());
                break;
            }

            catch(NumberFormatException e){
                System.out.print("Enter an Integer");
            }
        }while(true);