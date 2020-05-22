public Wallet findWallet(String userName, String password) {
    return wallets.stream()
        .filter(e -> e.getUserName().equals(userName))
        .filter(e -> e.getPassword().equals(password))
        .findAny()
        .orElse(null);
}