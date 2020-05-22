package stackoverflow.q1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

Integer accountNumber;
String customerName;
Double accountBalance;
Double startingBalance;
Double annualInterestRate;
Double monthlyDeposit;
Double monthlyWithdraw;
Double balanceAfterTransfer;
BankAccount account;
Scanner input;
private char[] passwordAccount;
List<BankAccount> accountDetails = new ArrayList<>();


public void bankAccount1Details() {
    for (int x = 0; x < (x + 1); x++) {
        System.out.println("");
        System.out.println("Please Enter The Following Details To create The Bank Account");
        System.out.println("");
        System.out.println("The Customer Account Number");
        accountNumber = input.nextInt();

        for (int a = 0; a < accountDetails.size(); a++) {
            if (accountNumber == account.accountNumber) {
                System.out.println("The account number already exist");
                bankAccount1Details();
            }
        }
        if (accountNumber == 0) {
            System.out.println("you have entered 0 for account number");
            break;
        }

        if ((accountNumber < 1000) || (accountNumber > 9999)) {
            System.out.println("Please Enter a valid Account number");
            bankAccount1Details();
        }

        System.out.println("The Customer Name");
        customerName = input.next();

        System.out.println("The Customer Account Balance");
        startingBalance = enterAccountBalance();

        annualInterestRate = enterAnnualIntrestRate();

        monthlyDeposit = enterMonthlyDeposit();

        monthlyWithdraw = enterMonthlyWithdraw();


        System.out.println("The Account Password");
        passwordAccount = input.next().toCharArray();

        account = new BankAccount(accountNumber, customerName, accountBalance,
                                  balanceAfterTransfer,
                                  annualInterestRate, startingBalance,
                                  monthlyDeposit, monthlyWithdraw);

        accountDetails.add(account);
    }
    computeInterest(accountDetails);
}

private Double enterMonthlyWithdraw() {
    do {
        System.out.println("please enter the monthly withdrawal amount");
        monthlyWithdraw = input.nextDouble();
        if ((monthlyWithdraw < 0)) {
            System.out.println("ERROR: Withdraw amount, not valid");
            monthlyDeposit = input.nextDouble();
        }
    } while (monthlyWithdraw < 0);
    return monthlyWithdraw;
}

private Double enterMonthlyDeposit() {
    do {
        System.out.println("please enter the monthly Automatic Deposit Amount ");
        monthlyDeposit = input.nextDouble();
        if (monthlyDeposit < 0) {
            System.out.println("ERROR: Withdraw amount, not valid");
            monthlyDeposit = input.nextDouble();
        }
    } while (monthlyDeposit < 0);
    return monthlyDeposit;
}

private Double enterAnnualIntrestRate() {
    do {
        System.out.println("Please Enter the Annual Interest Rate :");
        annualInterestRate = input.nextDouble();

        if ((annualInterestRate < 0.01) || (annualInterestRate > 15)) {
            System.out.println("Please enter a valid rate");
        }
    } while ((annualInterestRate < 0.01) || (annualInterestRate > 15));
    return annualInterestRate;
}

private Double enterAccountBalance() {
    do {
        accountBalance = input.nextDouble();
        if (accountBalance <= 0) {
            System.out.println("Please enter a valid amount");
        }
    } while ((accountBalance <= 0));
    return accountBalance;
}



//you can pass the whole list to this method 
public void computeInterest( List<BankAccount> accounts){

    int interestEarningYears;
    double yearlyBalance = 0;

    for (BankAccount account: accounts) {
        System.out.println("please enter the number of years the interest to be earned");
        interestEarningYears = input.nextInt();
        for (int x = 0; x <= interestEarningYears; x++) {
            yearlyBalance = accountBalance;
            double interest = ((account.annualInterestRate * yearlyBalance) / 100);
            yearlyBalance = yearlyBalance + interest;
            System.out.println("Ending balance for the year " + x + ": " + yearlyBalance);


            //set the account field in here 
            //I am not sure which field in the back account that has to store the yearlyBalance because you 
            //did not share all the calsses 
            //account.setXXXX(yearlyBalance);
        }
    }
}