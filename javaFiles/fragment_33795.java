import java.util.Scanner;


public class CreateLoans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Loan[] loans = new Loan[5];

        for(int i=0;i<5;i++) {
            loans[i] = new Loan();
            System.out.println("Please Enter the current prime interest rate");
            float prime = sc.nextInt();
            prime = (float)(prime/100f);
            loans[i].setPrime(prime);


            //ask for Personal or Business
            System.out.println("are you after a business or personal loan? Type business or personal");
            String loanType = sc.next();
            loans[i].setLoanType(loanType);

            //enter the Loan amount
            System.out.println("Enter the amount of loan");
            float amountOfLoan = sc.nextFloat();
            loans[i].setAmountOfLoan(amountOfLoan);

            //enter Customer Names  
            System.out.println("Enter First Name");
            String customerFirstName = sc.next();
            loans[i].setCustomerFirstName(customerFirstName);

            System.out.println("Enter Last Name");
            String customerLastName = sc.next();
            loans[i].setCustomerLastName(customerLastName);
        }

        //Display details 

        for(int i=0;i<5;i++) {
            System.out.println(loans[i]);
        }
    }
}

class Loan {
    private float prime;
    private float amountOfLoan = 0;
    private String customerFirstName;
    private String customerLastName;
    private String LoanType;
    public float getPrime() {
        return prime;
    }
    public void setPrime(float prime) {
        this.prime = prime;
    }
    public float getAmountOfLoan() {
        return amountOfLoan;
    }
    public void setAmountOfLoan(float amountOfLoan) {
        this.amountOfLoan = amountOfLoan;
    }
    public String getCustomerFirstName() {
        return customerFirstName;
    }
    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }
    public String getCustomerLastName() {
        return customerLastName;
    }
    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }
    public String getLoanType() {
        return LoanType;
    }
    public void setLoanType(String loanType) {
        LoanType = loanType;
    }

    @Override
    public String toString() {
        return "First Name : " + customerFirstName + "\n" +
               "Last Name : " + customerLastName + "\n" +
               "Amount of Loan : " + amountOfLoan + "\n" +
               "Loan type : " + LoanType + "\n" +
               "Prime : " + prime + "\n\n"; 
    }
}