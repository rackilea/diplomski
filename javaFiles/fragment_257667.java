public void setBalance(int balanceParam) {
    if (balanceParam < 0) {
        throw new IllegalArgumentException("Error: Invalid balance");
    }
    balance = balanceParam;
}