private class DateTypeAdapterFactory implements TypeAdapterFactory {
    private DateFormat yearMonthDayFormat = DateFormatters.getDateFormatInUserTimeZone(FORMAT_TYPE_YYYY_MM_DD);
    private DateFormat dateHourMinuteFormat = DateFormatters.getDateFormatInUserTimeZone(DateFormatters.FORMAT_TYPE_ISO8601_NO_SECONDS);

    private Pattern yearMonthDayPattern = Pattern.compile("^\\d{4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$");
    private Pattern dateHourMinutePattern = Pattern.compile(
            "[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])T(2[0-3]|[01][0-9]):[0-5][0-9]");

    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        final TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);
        if (!Date.class.isAssignableFrom(type.getRawType())) return null;

        return (TypeAdapter<T>) new TypeAdapter<Date>() {
            public Date read(JsonReader reader) throws IOException {
                if (reader.peek() == JsonToken.NULL) {
                    reader.nextNull();
                    return null;
                }

                try {
                    return (Date) delegate.read(reader);
                } catch (JsonSyntaxException jse) {
                    // DefaultDateTypeAdapter.deserializeToDate sets the date string as the JsonSyntaxException message,
                    // allowing us to try parsing it our own way.
                    String dateString = jse.getMessage();

                    try {
                        // If default date parsing fails, try one of the two funky new formats. Here we're using
                        // precompiled regexes for performance, but we could also try parsing and checking for
                        // ParseExceptions - that's what DefaultDateTypeAdapter does.
                        if (yearMonthDayPattern.matcher(dateString).matches()) {
                            return yearMonthDayFormat.parse(dateString);
                        } else if (dateHourMinutePattern.matcher(dateString).matches()) {
                            return dateHourMinuteFormat.parse(dateString);
                        } else {
                            throw jse;
                        }
                    } catch (ParseException pe) {
                        Timber.wtf(pe);
                        return null;
                    }
                }
            }

            @Override
            public void write(JsonWriter out, Date value) throws IOException {
                delegate.write(out, (T)value);
            }
        };
    }
}