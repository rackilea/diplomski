/**
 * Populate a full list of stocks from a given range
 * 
 * @param stockRange the stock range pulled from the DB, in this format: "XXX###-XXX###"
 * @return list of all stocks in the specified range
 */
public List<String> getFullStockRange(final String stockRange) {
    final String[] values = stockRange.split("-"); 
    final Integer first = Integer.parseInt(values[0].substring(3));
    final Integer last = Integer.parseInt(values[1].substring(3));
    final String prefix = values[0].substring(0, 3);

    final List<String> list = new LinkedList<>();

    for (int i = first; i<= last; i++) {
        final String entry = String.format("%s%03d", prefix, i);
        list.add(entry);
    }

    return list;
}