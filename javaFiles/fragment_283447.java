totalAmount = 0L;
Map<String, Money> totals = captureFile.getTotalMoney();
for (Entry<String, Money> money : totals.entrySet()) {
    try {
        totalAmount = totalAmount + money.getValue().getEquivalent(BASE_CURRENCY).getAmount();
    }
    ... 
}