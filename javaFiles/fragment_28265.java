public class Container

    private volatile Date date;
    private volatile int amount;

    public void update(int amount){
        int actualAmount;
        if (check(date)) {
              //do some BULK computation to compute the actualAmount

             date = new Date();
             this.amount = actualAmount;
        }
    }

    private boolean check(Date date) {

          //reading from the date and returning true if the date is expired
    }
}