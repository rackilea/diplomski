public static Matcher<Long> is(Float value) {
    return org.hamcrest.core.Is.is(value.longValue());
}

public static Matcher<Long> is(Double value) {
    return org.hamcrest.core.Is.is(value.longValue());
}