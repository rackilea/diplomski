package com.mypackage;

public class CustomerAmountResult{

    private String surname;
    private BigDecimal amountSum;

    public CustomerAmountResult(String surname, BigDecimal amountSum){
       this.surname = surname;
       this.amountSum = amountSum;
    }

    // getters / setters
}