if (input_without_year) {
    LocalDate d = MonthDay
                      .parse("12/06", DateTimeFormatter.ofPattern("MM/dd"))
                      .atYear(1970);
} else {
    // use formatter with year, without default values
}