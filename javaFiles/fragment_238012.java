import java.util.Scanner;   //CAPTURES USERS INPUT VIA THE KEYBOARD

public class PracticeFromStackOverFlow
{

public PracticeFromStackOverFlow()
{

}

public static void main(String[] args)
{

    char response = 0; //STORES USERS RESPONSE
    boolean outerLoop = true; //LOOP CONTROL VARIABLE FOR OUTER DO WHILE LOOP
    boolean innerLoop = true; //LOOP CONTROL VARIABLE FOR INNER DO WHILE LOOP
    double grossAnnualIncome = 0.0; //STORES USERS GROSS ANNUAL INCOME
    double annualTuition = 0.0; //STORES USERS ANNUAL TUITION PAYMENTS
    double annualCharity = 0.0; //STORES USERS ANNUAL DONATIONS TO CHARITY
    double homeMortgage = 0.0; //STORES USERS ANNUAL HOME MORTGAGE PAYMENTS
    double healthCredit = 0.0; //STORES USERS HEALTH INSURANCE CREDIT
    double annualAfterTaxes = 0.0; //STORES USERS ANNUAL INCOME AFTER TAXES
    double monthlyAfterTaxes = 0.0; //STORES USERS MONTHLY INCOME AFTER TAXES
    double taxOwed = 0.0; //STORES USERS TAX RATE AT A FIXED RATE OF 17%
    double taxableIncome = 0.0; //STORES USERS TAXABLE INCOME
    double taxCredits = 0.0; //STORES ALL OF THE USERS TAX CREDITS ADDED TOGETHER

    Scanner input = new Scanner(System.in); //ALLOWS THE USER TO ENTER THEIR CURRENT TAX INFORMATION

    while(outerLoop)
    {
        innerLoop = true; // reset this every time you 
        while(innerLoop) {

            System.out.print( "\nPlease enter your gross annual income or 0 for none:  " ); //PROMPT 1
            grossAnnualIncome = input.nextDouble();

            if( grossAnnualIncome > 0 ) {

                System.out.print( "\nPlease enter your annual tuition and expenses for higher education or 0 for none:  ");
                annualTuition = input.nextDouble();

                System.out.print( "\nPlease enter your annual charitable contributions or 0 for none:  ");
                annualCharity = input.nextDouble();

                System.out.print( "\nPlease enter the annual interest paid for your home mortgage or 0 for none:  ");
                homeMortgage = input.nextDouble();
                input.nextLine();

                System.out.print( "\nDid you purchase health insurance through your employer or outside the workplace?"
                        + " Enter 'Y' or 'N':  ");
                response = input.nextLine().charAt(0);
                healthCredit = 0;

                if( Character.toUpperCase(response) == 'Y' ) {

                    System.out.print( "\nAre you filing as a family?  Enter 'Y' or 'N':  "); //PROMPT 6
                    response = input.nextLine().charAt(0);


                    if ( Character.toUpperCase(response) == 'Y' ) {

                        healthCredit = 3500;
                    } else { // do you really need this?  

                        if( Character.toUpperCase(response) == 'N' ) {

                            System.out.print( "\nAre you filing as single?  Enter 'Y' or 'N':  "); //PROMPT 7
                            response = input.nextLine().charAt(0);
                        }

                        if( Character.toUpperCase(response) == 'Y') {

                            healthCredit = 2000;
                        }

                    }

                } 

                System.out.printf( "\nAre the following entries correct?\n\n"
                        + "Gross Annual Income:  $%,.0f\n\n"
                        + "Deductions: \n"
                        + "\tHigher Education:  %,.0f\n"
                        + "\tCharitable Contributions:  %,.0f\n"
                        + "\tHome Mortgage Interest:  %,.0f\n"
                        + "\tHealth Insurance Tax Credit:  %,.0f\n\n", grossAnnualIncome, annualTuition,                                    annualCharity, homeMortgage, healthCredit);

                System.out.print( "\nEnter 'Y' or 'N': ");
                response = input.nextLine().charAt(0);

                if( Character.toUpperCase(response) == 'Y'){
                    innerLoop = false;

                }
            } else {
                innerLoop = false;
            }
        }


                //CALCULATIONS
    taxableIncome  = grossAnnualIncome - taxCredits;
        taxOwed = taxableIncome * .17; //TAKES TAXABLE INCOME AND MULTIPLIES IT BY A 17% FLAT TAX RATE
        annualAfterTaxes = grossAnnualIncome - taxOwed; //TAKES USERS GROSS ANNUAL INCOME SUBTRACTED BY 17% TAX BRACKET
        monthlyAfterTaxes  = annualAfterTaxes  / 12; //DIVIDES THE USERS ANNUAL GROSS AFTER TAXES BY 12 FOR MONTHLY GROSS
        taxCredits = annualTuition + annualCharity + homeMortgage + healthCredit; //ADDS UP THE USERS TOTAL ANNUAL TAX

    if( grossAnnualIncome == 0 ) {

        System.out.print( "\nYou earned no income so you owe no taxes!" ); //GROSS ANNUAL INCOME EQUALS ZERO OUTPUT
        input.nextLine();
    }

    else if(grossAnnualIncome <= taxCredits ) {
        System.out.print( "\nYOU OWE $0.00 IN TAXES!" ); //GROSS ANNUAL INCOME LESS THAN OR EQUAL TO TAX CREDITS OUTPUT
    }

    else {


            //GROSS ANNUAL INCOME GREATER THAN ZERO OUTPUT
    System.out.printf( "\n\nYOUR TAXES\n\n"
                    + "Gross Annual Income:  $%,.0f\n\n"
                    + "Deductions: \n"
                    + "\tHigher Education:  %,.0f\n"
                    + "\tCharitable Contributions:  %,.0f\n"
                    + "\tHome Mortgage Interest:  %,.0f\n"
                    + "\tHealth Insurance Tax Credit:  %,.0f\n\n"
                    + "Tax at 17%%:  $%,.0f\n"
                    + "Annual Income After Tax:  $%,.0f\n"
                    + "Monthly Income After Tax:  $%,.0f", grossAnnualIncome, annualTuition, annualCharity,
                       homeMortgage, healthCredit, taxOwed, annualAfterTaxes, monthlyAfterTaxes);

    }

    System.out.print( "\n\nDo you want to calculate taxes for someone else?  Enter 'Y' or 'N' ");
     response = input.nextLine().charAt(0);

    if( Character.toUpperCase(response) == 'N') {
        System.out.print( "Laters");
        outerLoop = false;
    }

}

System.exit(0);

}

}