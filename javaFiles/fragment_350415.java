public static List<LocalDate> datesBetween(LocalDate start, LocalDate end) {
    List<LocalDate> ret = new ArrayList<LocalDate>();
    for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
        ret.add(date);
    }
    return ret;
}