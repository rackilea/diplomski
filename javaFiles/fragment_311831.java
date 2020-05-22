public class MyAggregator {

    private BigDecimal change;

    private TreeSet<Ticker> orderedTickers = new TreeSet<>(MyAggregator::tickerTimeComparator);

    public MyAggregator () {
        this.windowMilis = 86400000;
    }

    public MyAggregator addTicker(Ticker ticker) {
        orderedTickers.add(ticker);
        cleanOldTickers();
        change = getLatest().getAsk().subtract(getEarliest().getAsk());
        return this;
    }

    public BigDecimal getChange() {
        return change;
    }

    public Ticker getEarliest() {
        return orderedTickers.first();
    }

    public Ticker getLatest() {
        return orderedTickers.last();
    }

    private void cleanOldTickers() {
        Date endOfWindow = latestWindow();

        Iterator<Ticker> iterator = orderedTickers.iterator();
        while(iterator.hasNext()) {
            Ticker next = iterator.next();
            if (next.getTimestamp().before(endOfWindow)) {
                iterator.remove();
            }
            // The collection is sorted by time so if we get here we can break.
            break;
        }
    }

    private Date latestWindow() {
        return new Date(getLatest().getTimestamp().getTime() - windowMilis);
    }

    private static int tickerTimeComparator(Ticker t1, Ticker t2) {
        return t1.getTimestamp().compareTo(t2.getTimestamp());
    }

}