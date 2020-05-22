public class IBANChecker03 {

    public static void printValid(String iban){
        System.out.printf("%s is %s.%n", iban, validateIBAN(iban) ? "valid" : "not valid");
    }

    public static void main(String[] args) {
        String[] ibans = {"IBAN goes here"};
        for(String iban : ibans){
            printValid(iban);
        }
    }

    static boolean validateIBAN(String iban){
        //Validation code
    }
}

public class HomeOffice {
    public static void main(String[] args) {
        //Code to get cell
        String cellvalue = cell.toString();
        IBANChecker03.printValid(cellvalue);
    }
}