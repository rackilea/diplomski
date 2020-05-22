public class bankAccount
{
    private String accountNum;// instance variable

        public bankAccount () {
            accountNum = "X00000"; 
        }
            public String getaccountNum () {
                return accountNum;
            }

    public static void main(String []args) {
        bankAccount account = new bankAccount ();
        System.out.println(account.getaccountNum() + " " + account.isValidLenght(account.getaccountNum()));
    }

    public boolean isValidLenght(String s) {
        if (s.length() == 6) {
            return true;
        }else {
        return false;
        }
    }
}