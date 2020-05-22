public double getloanAmount(){

        return loanAmount - depositAmt;
    }

    public double getMonthlyPayment() {
        rate /= 100.0;

        double loanAmount = getloanAmount();

        double monthlyRate = rate / 12.0;

        int termMonths = termYears * 12;

   double monthlyPayment = (loanAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -termMonths));

        return monthlyPayment;
    }