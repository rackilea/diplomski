public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("What is your Phrase? "); 
        String inputStr;
        inputStr = keyboard.nextLine();
        System.out.println("Enter a Integer");
        int inputInt;
        inputInt=keyboard.nextInt();
        for(int i =0;i<inputStr.length();i+=inputInt){     
            if(i+inputInt < inputStr.length())
                System.out.println(inputStr.substring(i,i+inputInt));
            else
                System.out.println(inputStr.substring(i,inputStr.length()));
        }
    }