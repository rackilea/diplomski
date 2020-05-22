private static int sticks;
    private static Scanner startInput;

    public static void main(String[] args) {
        sticks = 0;
        startInput = new Scanner(System.in);        
        while (sticks >= 0) {            
            try {
                System.out.println("How many sticks do you want?");
                sticks = Integer.parseInt(startInput.nextLine());
            } catch (NumberFormatException e) {
                sticks = 0;     //Any value which is not 0 will not break your loop. This will be re-populated when the user will supply the number again.
                System.out.println("Please enter a valid number.");
            }
        }
    }