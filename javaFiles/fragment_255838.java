@Override
public boolean withdraw(User user, int amount) {
    if (!checkWithdraw(user, amount)) return false;
    user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));
    return true;
}

@Override
public boolean fund(User user, int amount) {
    if (!checkFund(user, amount)) return false;
    user.setBalance(user.getBalance() + amount);
    return true;
}

@Override
public boolean transferMoney(User fromUser, User toUser, int amount) {
    if (fromUser.getBank().getCurrency() != toUser.getBank().getCurrency()) return false;
    return withdraw(fromUser, amount) && fund(toUser, amount);
}