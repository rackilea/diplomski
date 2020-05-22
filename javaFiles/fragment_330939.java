private Currency(String code, String name, boolean major) {
    this.code = code;
    this.name = name;
    this.major = major;
}

public static Currency of(String code, String name, boolean major) {
    return new Currency(code, name, major);
}