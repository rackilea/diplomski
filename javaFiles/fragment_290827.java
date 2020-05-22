public static List<ProfitAndLossDataDO> sumPerLedgerName
    (List<ProfitAndLossDataDO> list) {

    Map<String, ProfitAndLossDataDO> map = new HashMap<>();

    for (ProfitAndLossDataDO p : list) {
        String name = p.getLedgerName();
        ProfitAndLossDataDO sum = map.computeIfAbsent(name, n -> new ProfitAndLossDataDO(n, 0.0));
        sum.setLedgerAmount(sum.getLedgerAmount() + p.getLedgerAmount());
    }
    return new ArrayList<>(map.values());
}