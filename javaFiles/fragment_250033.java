@Override
public LocalDate convertToPresentation(java.sql.Date value, ValueContext context) {
    if (value == null) {
        //return LocalDate.now();
        return null;
    }
    return value.toLocalDate();
}