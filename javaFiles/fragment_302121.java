public static void printInt(SavingsAccount1 f) {
    getInt(f);
    print(f);
}
public static void print(SavingsAccount1 f) {
    System.out.printf("%12d%10.2f ", f.getAccount_Number(),
            f.getBalance());
}
public static void getInt(SavingsAccount1 f) {
    f.addMonthlyInterest(f.getBalance());
}