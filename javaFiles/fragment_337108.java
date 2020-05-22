if (field.getType().isAssignableFrom(ZonedDateTime.class)) {
    // ZonedDateTime, use a value formatter
    report.addColumn(Columns.column(fieldName, fieldName, ZonedDateTime.class)
        // set a custom value formatter
        .setValueFormatter(new AbstractValueFormatter<String, ZonedDateTime>() {
            @Override
            public String format(ZonedDateTime value, ReportParameters reportParameters) {
                // convert ZonedDateTime to dd.MM.yyyy format
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                return value.format(fmt);
            }
        }));
} else if (field.getType().isAssignableFrom(Date.class)) {
    // java.util.Date: setPattern works
    report.addColumn(Columns.column(fieldName, fieldName, field.getType()).setPattern("dd.MM.yyyy"));
...