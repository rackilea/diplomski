private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
public static int code(String dateStr) {
    LocalDate date = LocalDate.parse(dateStr, formatter);
    LocalDate today = LocalDate.now();
    return today.getYear() == date.getYear() ? date.getDayOfYear() - today.getDayOfYear() + 1 : date.getDayOfYear() ;
}