public class MapEquivalent<T, U> extends TypeSafeDiagnosingMatcher<Map<T, U>> {

    private Map<T, U> m_expected;

    public MapEquivalent(Map<T, U> expected) {
        m_expected = expected;
    }

    public static <T, U> MapEquivalent<T, U> mapEquivalent(Map<T, U> expected) {
        return new MapEquivalent<>(expected);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Maps are equivalent");
    }

    @Override
    protected boolean matchesSafely(Map<T, U> actual, Description description) {
        boolean matched = true;

        Set<T> keys = new HashSet<>();
        keys.addAll(actual.keySet());
        keys.addAll(m_expected.keySet());

        for (T key: keys) {
            U expectedValue = m_expected.get(key);
            U actualValue = actual.get(key);

            if (null == expectedValue) {
                matched = false;
                description
                        .appendText("\n\t\tOnly in actual: {").appendValue(key)
                        .appendText(": ").appendValue(actualValue).appendText("}");
            } else if (null == actualValue) {
                matched = false;
                description
                        .appendText("\n\t\tOnly in expected: {").appendValue(key)
                        .appendText(": ").appendValue(expectedValue).appendText("}");
            } else if (!actualValue.equals(expectedValue)) {
                matched = false;
                description
                        .appendText("\n\t\tValues differ: ")
                        .appendText("actual={").appendValue(key).appendText(": ").appendValue(actualValue).appendText("}")
                        .appendText(", expected={").appendValue(key).appendText(": ").appendValue(expectedValue).appendText("}");

            }
        }

        return matched;
    }
}