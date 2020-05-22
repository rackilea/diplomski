public BigDecimal[] calculate(BigDecimal[] percentages, BigDecimal amount) {
     BigDecimal rolling = amount;
     BigDecimal[] result = new BigDecimal[percentages.length];
     for (int i = 0; i < percentages.length; i++) {
        // We use null as a marker for subtotals
        if (percentages[i] != null) {
           result[i] = amount.multiply(percentages[i]).divide(new BigDecimal("100"), MathContext.DECIMAL128);
           rolling = rolling.add(result[i]);
        } else {
           // Insert the subTotal
           result[i] = rolling;
        }
     }