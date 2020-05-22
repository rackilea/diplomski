public class Transaction {

    private String target;
    private String source;
    private String operation;
    private int amount;

    public Transaction(String target, String source, String operation, int amount) {
        this.target = target;
        this.source = source;
        this.operation = operation;
        this.amount = amount;
    }

    // + getters

}