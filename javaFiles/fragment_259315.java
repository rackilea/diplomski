public static void main(String[] args) {
            String[] romanNumbers= {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

            int number;
            Scanner keyboard = new Scanner(System.in);
            //Storing Number
            System.out.println("Pick a number, 1 - 10");
            number = keyboard.nextInt();
            //If statements and Outputs
            if (number > 10 || number < 1)
                //Error message
                System.out.print("Error, " + number + " is higher than 10.\nPlease try again");
            else
                System.out.println("Roman Numeral: " + romanNumbers[number -1]);
        }
    }