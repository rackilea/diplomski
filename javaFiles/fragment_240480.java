public class IBANChecker03 {

    public static void main(String[] args) {
        String[] ibans = args;
        for(String iban : ibans){
            System.out.printf("%s is %s.%n", iban, validateIBAN(iban) ? "valid" : "not valid");
        }
    }

    static boolean validateIBAN(String iban){
        // validation code
    }
}

public class HomeOffice {
    public static void main(String[] args) {
        String[] vals = new String[]{"5616516", "8984546", "6516546", "9684654"};
        IBANChecker03.main(vals);
    }
}