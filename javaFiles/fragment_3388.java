public String listProjectedPortfolioTimeframe(double desiredBalance) {
        String str = "";
        double amountOfIncreasePerYear = 50; // You need to replace this...
        for (BankAccount ba: bankAccounts) {
            String currentBalance = ba.getBalance();
            if(Double.parseDouble(currentBalance) <= desiredBalance)
            {
                double numberOfYears = (desiredBalance - Double.parseDouble(currentBalance)) / amountOfIncreasePerYear;
                String currentAccNumber = ba.getAccNumber();
                str += String.Format(
                    "Account#: %s, Current Balance: %.2f, Number of Years to Reach %.2f: %f \r\n",
                    currentAccNumber, currentBalance, desiredBalance, numberOfYears
                    );
            }
        }
        if(str == "") {
            str = "No Bank Accounts";
        }
        return str;
    }