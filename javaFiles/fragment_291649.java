private static final Converter<Date, LocalDate> DATE_TO_LOCAL_DATE_CONVERTER = mappingContext -> {
    Date source = mappingContext.getSource();
    return source.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
};

private static final Converter<LocalDate, Date> LOCAL_DATE_TO_DATE_CONVERTER = mappingContext -> {
    LocalDate source = mappingContext.getSource();
    return Date.from(source.atStartOfDay(ZoneId.systemDefault()).toInstant());
};