public class JavaBank {
    static JavaBank user = new JavaBank();
    int accountNumber = 1000;
    int initialDeposit;
    String name;
    private String username;
    int pincode;
    int verify;
    private static int counter = 0;//Add here and remove from main()
    private static JavaBank newUser[] = new JavaBank[10];//add here and remove from main()

    public JavaBank() {
        accountNumber = 1000;
        name = "name";
        username = "username";
        pincode = 1000;
        verify = 1000;
        initialDeposit = 5000;
    }
.
.
.