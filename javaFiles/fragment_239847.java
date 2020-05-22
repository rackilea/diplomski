public static TemporalAccessor withYear(TemporalAccessor t, long year) {
    return new TemporalAccessor() {

        @Override
        public boolean isSupported(TemporalField field) {
            // epoch day is used by LocalDate.from
            if (field == ChronoField.YEAR_OF_ERA || field == ChronoField.EPOCH_DAY) {
                return true;
            } else {
                return t.isSupported(field);
            }
        }

        @Override
        public long getLong(TemporalField field) {
            if (field == ChronoField.YEAR_OF_ERA) {
                return year;
                // epoch day is used by LocalDate.from
            } else if (field == ChronoField.EPOCH_DAY) {
                // Assuming the input always have month and day
                // If that's not the case, you can change the code to use default values as well,
                // and use MonthDay.of(month, day)
                return MonthDay.from(t).atYear((int) year).toEpochDay();
            } else {
                return t.getLong(field);
            }
        }
    };
}