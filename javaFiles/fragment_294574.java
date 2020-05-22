public class Main {
    public static void main(String[] args) {
        for(int x = 0; x < bankAccountArray.length; x++){
            System.out.print("Enter bank account number: ");
            int bankNumber = number.nextInt();
            checkAcctNum(bankNumber, bankAccountArray[x]);
        }
    }
}