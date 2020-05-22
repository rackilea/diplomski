public class AccountDebitCredit {

    private int accountBalance = 100;

    public static void main(String[] args) throws InterruptedException {
        final AccountDebitCredit accountDebitCredit = new AccountDebitCredit();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    // if you remove synchronization from t1 and t2, then there would be concurrency issues.
                    synchronized (accountDebitCredit) {
                        accountDebitCredit.accountBalance = accountDebitCredit.accountBalance + 100;
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    // if you remove synchronization from t1 and t2, then there would be concurrency issues.
                    synchronized (accountDebitCredit) {
                        accountDebitCredit.accountBalance = accountDebitCredit.accountBalance - 100;
                    }
                }
            }
        });

        System.out.println(accountDebitCredit.accountBalance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(accountDebitCredit.accountBalance);
    }

}