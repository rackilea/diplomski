public static Week fetchValue(String constant) {
    for (Week week : Week.values()) {
        if (week.value.equals(constant)) {
            return week;
        }
    }
    return null;
}