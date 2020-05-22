final FieldType type = new FieldType();
            type.setNumericPrecisionStep(4);
            type.setStored(true);
            type.setIndexed(true);
            type.setNumericType(FieldType.NumericType.LONG);
            doc.add(new LongField("BirthDate", parseDate("1969/01/31 16:17:18").getTime(), type));