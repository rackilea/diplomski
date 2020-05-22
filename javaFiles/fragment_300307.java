// This will be your converter
class DateTimeConverter implements Converter<Timestamp, DateTime> { ... }

// This is how you create a new data type:
public static final DataType<DateTime> DATETIME = 
    SQLDataType.TIMESTAMP.asConvertedDataType(new DateTimeConverter);