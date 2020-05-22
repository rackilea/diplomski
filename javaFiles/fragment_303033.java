public Map<AmountType, Amount> getAmounts() {
    Map<AmountType, Amount> result = new HashMap<AmountType, Amount>(3);
    result.put(AmountType.ATM, amountAtm);
    result.put(AmountType.BRANCH, amountBranch);
    result.put(AmountType.VAULT, amountVault);
    return result;
}