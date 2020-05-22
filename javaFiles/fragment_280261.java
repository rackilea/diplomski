class Thief extends Thread {
    public BankAccount ba = null;
    void run() {
        do { 
            if(ba != null) ba.transferAllMoneyToDima();           
        } while(ba == null);
    }
}

Thief th = new Thief();
th.start();
th.ba = new BankAccount();