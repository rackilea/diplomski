public static final Period ZERO = new Period(0, 0, 0);

public static Period of(int years, int months, int days) {
    return create(years, months, days);
}
private static Period create(int years, int months, int days) {
    if ((years | months | days) == 0) {
        return ZERO;
    }
    return new Period(years, months, days);
}
private Period(int years, int months, int days) {
    this.years = years;
    this.months = months;
    this.days = days;
}