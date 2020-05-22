public static void main(String[] args) {
    // set-up sample data
    Map<String, Integer> map = new HashMap<>();
    for (String s : Arrays.asList("A", "B", "C", "D", "X")) {
        map.put(s, 1000);
    }
    List<Transaction> transactions = Arrays.asList(
        new Transaction("A","B","Add",10),
        new Transaction("C","D","Subtract",20),
        new Transaction("D","B","Add",50),
        new Transaction("B","X","Subtract",30)
    );

    // implement the transactions
    for (Transaction t : transactions) {
        final int amount = t.getOperation().equals("Add") ? t.getAmount() : -t.getAmount();
        map.put(t.getSource(), map.get(t.getSource()) - amount);
        map.put(t.getTarget(), map.get(t.getTarget()) + amount);
    }

    System.out.println(map); // prints "{A=1010, B=910, C=980, D=1070, X=1030}"
}