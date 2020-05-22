for (Iterator<Entry<String, BigDecimal>> it = testBene.entrySet().iterator(); it.hasNext();) {
    Entry<String, BigDecimal> beneKeySet = it.next();
    if (testDly.containsKey(beneKeySet.getKey())) {
        for (Entry<String, BigDecimal> dlyKeySet : testDly.entrySet()) {
            if ((dlyKeySet.getKey() == beneKeySet.getKey()) && dlyKeySet.getValue() == beneKeySet.getValue()) {
                it.remove();
            }
        }
    }
}