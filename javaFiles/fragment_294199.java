@Override
     public void deposit(int amount) {
        if (amount <= depositRemaining){
            setBalance(getBalance() + amount);
            }

}