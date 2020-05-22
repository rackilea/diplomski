public class Driver {

    public static void main (String[] args){
        BankAccount  acc1 = new BankAccount (1500);

        System.out.println("After Withdrawing Amount: $" +acc1.withdraw(50) +" The New Balance: $" +acc1.balance);
    }
}