public static double updateBal(boolean correctSide, double getBet){
            double balance = getBal();
            if (correctSide = true){
                    balance = getBet * 2 + balance;
                    System.out.println("Correct. Your balance is now $" + balance);
            } else {
                    balance = balance - getBet;
                    System.out.println("Incorrect. Your balance is now $" + balance);
            }
            return balance;
    }