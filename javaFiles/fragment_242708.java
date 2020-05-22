try{
        Scanner keyboard = new Scanner(System.in);
        int tries = 0;
        int maxTries = 2;
        double sum = 0;

        while (tries < 2) { 
            try {
                 while (keyboard.hasNext()){
                     double d = keyboard.nextDouble();
                     sum += d;
                     tries = 0; // reset counter because of valid input
                 }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Float values "
                        + "only please.");
                tries += 1; // tries +1 because invalid input
                keyboard.nextLine();
            }
        }
        System.out.printf("The sum of your inputs is: %f", sum);
    }catch(Exception e){
        e.printStackTrace();
    }