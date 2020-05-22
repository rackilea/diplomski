private Matcher<TradedInstrument> isEquivalent(final String instId, final PriceSource priceSource, final BigDecimal price) {
    return new BaseMatcher<TradedInstrument>() {
        @Override
        public boolean matches(final Object item) {
            final TradedInstrument tradedInstrument = (TradedInstrument) item;
            // your custom equality implementation e.g.
            return instId.equals(tradeInstrument.getInstId()) && priceSource == tradeInstrument.getPriceSource() && price.equals(tradeInstrument.getPrice());
        }
        @Override
        public void describeTo(final Description description) {
            description.appendText(String.format("the given object should contain id=%s, priceSource=%s, price=%s ", id, priceSource, price));
        }
    };
}