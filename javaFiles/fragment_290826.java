public static List<ProfitAndLossDataDO> sumPerLedgerName
    (List<ProfitAndLossDataDO> list) {

    Map<String, ProfitAndLossDataDO> map = new HashMap<>();

    for (ProfitAndLossDataDO p : list) {
        String name = p.getLedgerName();
        ProfitAndLossDataDO sum = map.get(name);
        if (sum == null) {
            sum = new ProfitAndLossDataDO(name, 0.0);
            map.put(name, sum);
        }
        sum.setLedgerAmount(sum.getLedgerAmount() + p.getLedgerAmount());
    }
    return new ArrayList<>(map.values());
}