BigDecimal decimalInterestRate = new BigDecimal(Double.toString(InterestRate));
        decimalInterestRate = decimalInterestRate.setScale(2, RoundingMode.HALF_UP);
        BigDecimal decimalLoanAmount = new BigDecimal(Double.toString(LoanAmount));
        decimalLoanAmount = decimalLoanAmount.setScale(2, RoundingMode.HALF_UP);

        // calculate interest
        BigDecimal Interest = decimalInterestRate.multiply(decimalLoanAmount);

        System.out.println("Interest:" + Interest);