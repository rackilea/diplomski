/**
     * Formats the specified object as a string using the pattern of this date
     * format and appends the string to the specified string buffer.
     * <p>
     * If the {@code field} member of {@code field} contains a value specifying
     * a format field, then its {@code beginIndex} and {@code endIndex} members
     * will be updated with the position of the first occurrence of this field
     * in the formatted text.
     *
     * @param object
     *            the source object to format, must be a {@code Date} or a
     *            {@code Number}. If {@code object} is a number then a date is
     *            constructed using the {@code longValue()} of the number.
     * @param buffer
     *            the target string buffer to append the formatted date/time to.
     * @param field
     *            on input: an optional alignment field; on output: the offsets
     *            of the alignment field in the formatted text.
     * @return the string buffer.
     * @throws IllegalArgumentException
     *            if {@code object} is neither a {@code Date} nor a
     *            {@code Number} instance.
     */
    @Override
    public final StringBuffer format(Object object, StringBuffer buffer, FieldPosition field) {
        if (object instanceof Date) {
            return format((Date) object, buffer, field);
        }
        if (object instanceof Number) {
            return format(new Date(((Number) object).longValue()), buffer, field);
        }
        throw new IllegalArgumentException("Bad class: " + object.getClass());
    }