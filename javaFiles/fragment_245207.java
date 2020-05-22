public class MaliciousDate extends Date { /** malicious code here **/ }

public class SomeClass {
    public static void main(String[] args) {
        MaliciousDate someDate = new MaliciousDate();
        Date copyOfMaliciousDate = someDate;
        Date anotherDate = copyOfMaliciousDate.clone();
    }
}