package com.jlb;

public class SavingsAccount {

    private int balance = 0;

    public SavingsAccount(int amount){
        this.balance = amount;
    }
    public int getBalance(){
        return this.balance;
    }

    public int compareTo(SavingsAccount secAccount)
    {
        int result;
        if ( balance > secAccount.getBalance() )
            result = 1;
        else if ( balance == secAccount.getBalance() )
            result = 0;
        else
            result = -1;

        return result;
    }
}