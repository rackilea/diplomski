public void checkAmmount() {


    for (int i = 0; i < 10; i++) {

        synchronized (this) {

            System.out.println(Thread.currentThread().getName()
                    + "checks balance: " + balance);

            withDrawAmmount();

        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}