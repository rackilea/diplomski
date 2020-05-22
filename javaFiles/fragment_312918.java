/**
 * Implements the Unicode category ALL and the dot metacharacter when
 * in dotall mode.
 */
static final class All extends CharProperty {
    boolean isSatisfiedBy(int ch) {
        return true;
    }
}