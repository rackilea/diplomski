if (field.getType().isAssignableFrom(ZonedDateTime.class)) {
    // ZonedDateTime, manually convert to String
    report.addColumn(Columns.column(fieldName, fieldName, String.class));
} else if (field.getType().isAssignableFrom(Date.class)) {
    // java.util.Date: setPattern works
    report.addColumn(Columns.column(fieldName, fieldName, field.getType()).setPattern("dd.MM.yyyy"));
} else {
    report.addColumn(Columns.column(fieldName, fieldName, field.getType()));
}