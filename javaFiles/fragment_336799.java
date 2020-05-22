public class PrimeNumbersTest {

    @TestFactory
    Stream<DynamicTest> test_first_1000_prime_numbers() throws Exception {
        return primes().mapToObj(p -> DynamicTest.dynamicTest(
                // Test case name.
                "Prime: " + p,
                // Test case content.
                () -> assertTrue(PrimeNumbers.isPrime(p))));
    }

    private LongStream primes() throws Exception {
        return Files.lines(Paths.get(getClass().getResource("/primes-1000.txt").toURI()))
                .mapToLong(Long::parseLong);
    }

}