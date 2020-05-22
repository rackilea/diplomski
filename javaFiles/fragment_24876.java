public static boolean CheckcollectInteger(int inputValue,int minimum, int maximum){
            if (inputValue >= minimum && inputValue <= maximum){
                return true;       
            }else {
                return false;
            }
    }

   public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            final int MINIMUM =0, MAXIMUM =100;

            while(true){
                System.out.print("Enter a number of cats :");
                int catsNumber;
                //check input is integer or not
                try{
                    catsNumber = in.nextInt();
                }catche(Exception e){
                   System.out.println("Value needs to be an integer. Try again");
                   continue;
                }
                //check input valie is btw 0-100 or not
                boolean catInputCheck =  CheckcollectInteger(catsNumber,MINIMUM, MAXIMUM);
                if (catInputCheck){
                    System.out.printf("Your number of cats was %d", catsNumber);
                }else {
                    System.out.println("Value needs to be an integer between 0 and 100. Please try again.");
                }

                //----check continue or exit system
                System.out.print("Do you want to continue ? (yes / no)");
                String isContinue = in.nextLine();
                if(isContinue.equals("no") || isContinue.equals("NO")){
                    break; //exit loop
                }
            }
            in.close();     
        }