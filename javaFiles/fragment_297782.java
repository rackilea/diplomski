public void makeTwoDatesEqual(GregorianCalendar a, GregorianCalendar b) {
    Instant instantA = DateTimeUtils.toInstant(a);
    Instant instantB = DateTimeUtils.toInstant(b);
    System.out.println(instantA);
    System.out.println(instantB);

    Duration duration = Duration.between(instantA, instantB);

    Instant instantC = instantA.plus(duration);
    System.out.println(instantC);
    System.out.println(instantC.equals(instantB)); // true
}