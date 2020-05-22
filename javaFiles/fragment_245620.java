public class Account {
    private int studentId;
    ...
    CircularFifoQueue<Integer> lastTransactions = new CircularFifoQueue<Integer>(6);
}

public class StudentPrint {
    LinkedList<Account> accountList = new LinkedList<Account>();
}