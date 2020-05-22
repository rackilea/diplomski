static final String CONSTANT1 = ""; // compile-time constant
static final String CONSTANT2 = CONSTANT1; // compile-time constant
// but
static final String NO_CONSTANT1 = CONSTANT1.toString(); // not a constant expression
static final String NO_CONSTANT2; // no initializer
static {
    NO_CONSTANT2 = ""; // assignment in class initializer, valid, but not constant
}
static final BigInteger NO_CONSTANT3 = BigInteger.ONE; // neither primitive nor String