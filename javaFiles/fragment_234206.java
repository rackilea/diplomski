public class Bill {

    private long id;
    private String name;
    private String amount;
    private String duedate;

    public Bill(long id, String name, String amount, String duedate) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.duedate = duedate;
    }
    /*
            Note if this Constructor used then setId should be used
     */
    public Bill(String name, String amount, String duedate) {
        new Bill(0,name,amount,duedate);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    /*
            As ArrayAdapter uses toString method change this
            to return all items
     */
    @Override
    public String toString() {
        return name + " " + amount + " " + duedate;
    }
}