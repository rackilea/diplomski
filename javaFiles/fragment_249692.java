public ArrayList<Transaction> loadTransactions(){
    return loadFile(new File("data/transactions.ser"));
}

public ArrayList<Fund> loadFunds(){
    return loadFile(new File("data/funds.ser"));
}

private <T> ArrayList<T> loadFile(File file) {
    ArrayList<T> obj = new ArrayList<>();
    ...
    return (ArrayList<T>) in.readObject();
}