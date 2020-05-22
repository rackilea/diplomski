TreeMap<DateTime, BigDecimal> map = new TreeMap<>();
//populate the map

BigDecimal findNextSmaller(DateTime input) {
    return map.ceilingEntry(input).getValue(); //add exception checking as required
}