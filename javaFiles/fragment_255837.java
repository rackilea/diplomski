@Override
public boolean transferMoney(User fromUser, User toUser, int amount) {
    if (!checkWithdraw(fromUser, amount)) return false;
    if (!checkFund(toUser, amount)) return false;
    if (fromUser.getBank().getCurrency() != toUser.getBank().getCurrency()) return false;

    withdraw(fromUser, amount);
    fund(toUser, amount);
    return true;
}