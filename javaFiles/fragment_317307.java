public AreaData (String... data) {
        List<String> list = Arrays.asList(data);
        /* Assert to check that the data is of the expected number of items. */
        assert data.length == Field.values().length : "Incorrect number of fields";
        int width;
        String formatString;
        Stream.of(Field.values()).forEach(
                field -> {
                    if (field == NAME) {
                        /* Get the name value and store it away. */
                        String value = data[field.position()];
                        strings.put(field, value);
                        /* Get the needed width of the field to hold the name. */
                        width = max(value.length(), field.getFieldHeading().length());
                        formatString = "s";
                    } else {
                        /* If the value is of the wrong form, allow the NumberFormatException
                           to be thrown. */
                        Double value = Double.parseDouble(data[field.position()]);
                        /* Assertion to check value given is positive.  */
                        assert value.compareTo(0.0) >= 0 :
                                "invalid " + field.name() + " value=" + value.toString();
                        /* Get the field value and store it away. */
                        doubles.put(field, value);
                        /* Get needed width of the field to hold the heading or value. */
                        width = max((int) log10(value) + MINIMUM,
                                field.getFieldHeading().length() + HEADING_SEPARATION);
                        formatString = ".2f";
                    }
                    /* Keep the widest value seen, and record the corresponding format. */
                    if (width > WIDTHS.get(field)) {
                        WIDTHS.put(field, width);
                        FORMATS.put(field, "%" + width + formatString);
                    }
                });

        /* Optimization: to avoid doing this every time a comparison is made. */
        this.nameCaseless = strings.get(NAME).toUpperCase().toLowerCase();
    }