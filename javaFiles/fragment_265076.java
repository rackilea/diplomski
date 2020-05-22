Scanner sc = new Scanner(System.in);
        int x;
        do{
            try{
                x = sc.nextInt();
                break;
            }

            catch(InputMismatchException e){
                System.out.print("Enter an Integer");
            }
        }while(true);