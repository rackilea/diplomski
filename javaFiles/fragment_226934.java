public static class BigDecimalEqualComparator extends TypeSafeMatcher<BigDecimal> {

    private final BigDecimal expected;

    private static final String[] comparisonDescriptions = { "less than", "equal to", "greater than" };

    public BigDecimalEqualComparator( BigDecimal expected ) {
        this.expected = expected;
    }

    @Override
    public boolean matchesSafely( BigDecimal actual ) {
        return actual.compareTo( expected ) == 0;
    }

    // You must change this
    @Override
    public void describeMismatchSafely( BigDecimal actual, Description mismatchDescription ) {
        mismatchDescription.appendValue( actual.stripTrailingZeros().toPlainString() ).appendText( " was " )
            .appendText( asText( actual.compareTo( expected ) ) ).appendText( " " )
            .appendValue( expected.stripTrailingZeros().toPlainString() );
    }

    @Override
    public void describeTo( Description description ) {
        description.appendText( "a value equal to " ).appendValue( expected.stripTrailingZeros().toPlainString() );
    }

    private static String asText( int comparison ) {
        return comparisonDescriptions[signum( comparison ) + 1];
    }
}