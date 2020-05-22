package com.jlb;

public class Test{

    public static void main(String[] args)
    {
        SavingsAccount savings1 = new SavingsAccount(200);
        SavingsAccount savings2 = new SavingsAccount(100);

        if ( savings1.compareTo(savings2) > 0 )
            System.out.println("[client] Savings1 has the larger balance");
        else if (savings1.compareTo(savings2) == 0 )
            System.out.println("[client] Savings1 and Savings2 "
            + "have the same balance");
        else
            System.out.println("[client] Savings2 has the larger balance");
    }


}