public class PowerCalculator {

    public String[] power2(String x) {
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection") // update via increaseCountFor method
        PrimeFactorToCount primeFactorToCount = new PrimeFactorToCount();
        BigInteger number = new BigInteger(x);
        BigInteger divisor = new BigInteger("2");

        while (!number.equals(BigInteger.ONE)) {
            if (number.remainder(divisor).equals(BigInteger.ZERO)) {
                number = number.divide(divisor);
                primeFactorToCount.increaseCountFor(divisor);
            } else {
                if (gcd(primeFactorToCount.values()) == 1) {
                    return new String[] {x, "1"};
                }
                divisor = divisor.add(BigInteger.ONE);
            }
        }

        int gcd = gcd(primeFactorToCount.values());

        return primeFactorToCount.entrySet().stream()
                .map(entry -> new Exponentiation(entry.getKey(), entry.getValue()))
                .map(exponentiation -> new Exponentiation(exponentiation.base.pow(exponentiation.exponent / gcd), gcd))
                .reduce((a, b) -> new Exponentiation(a.base.multiply(b.base), gcd))
                .map(Exponentiation::asStringArray)
                .get();
    }

    private static int gcd(Collection<Integer> values) {
        return values.stream()
                .mapToLong(v -> v)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger::gcd)
                .map(BigInteger::intValue)
                .orElse(0);
    }

    private class Exponentiation {

        private final BigInteger base;
        private final int exponent;

        private Exponentiation(BigInteger base, int exponent) {
            this.base = base;
            this.exponent = exponent;
        }

        private String[] asStringArray() {
            return new String[] {String.valueOf(base), String.valueOf(exponent)};
        }

    }

    private class PrimeFactorToCount extends HashMap<BigInteger, Integer> {

        private void increaseCountFor(BigInteger primeFactor) {
            if (containsKey(primeFactor)) {
                put(primeFactor, get(primeFactor) + 1);
            } else {
                put(primeFactor, 1);
            }
        }

    }

}

@RunWith(Parameterized.class)
public class PowerCalculatorTest {

    private final uk.co.jpawlak.maptoobjectconverter.PowerCalculator powerCalculator = new uk.co.jpawlak.maptoobjectconverter.PowerCalculator();

    @Parameterized.Parameters(name = "{index}: returns {1} for {0}")
    public static Collection data() {
        return asList(new Object[][] {
                {input(3), expected(3, 1)},
                {input(7 * 7), expected(7, 2)},
                {input(2 * 2 * 2), expected(2, 3)},
                {input(3 * 3 * 5 * 5), expected(3 * 5, 2)},
                {input(3 * 3 * 5 * 5 * 5 * 5), expected(3 * 5 * 5, 2)},
                {input(3 * 3 * 3 * 3 * 3 * 3 * 5 * 5), expected(3 * 3 * 3 * 5, 2)},
                {input(2 * 3 * 3), expected(2 * 3 * 3, 1)},
        });
    }

    private final String input;
    private final String[] expected;

    public PowerCalculatorTest(String input, List<String> expected) {
        this.input = input;
        this.expected = expected.stream().toArray(String[]::new);
    }

    @Test
    public void test() {
        String[] actual = powerCalculator.power2(input);

        assertThat(actual, sameBeanAs(expected));
    }

    private static String input(long input) {
        return String.valueOf(input);
    }

    private static List<String> expected(long base, long exponent) {
        return ImmutableList.of(String.valueOf(base), String.valueOf(exponent));
    }

}

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static com.shazam.shazamcrest.MatcherAssert.assertThat;
import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static java.util.Arrays.asList;