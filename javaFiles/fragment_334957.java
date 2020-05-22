// I'm assuming you're storing the data as an INTEGER
DataType<DayOfWeek> type = SQLDataType.INTEGER.asConvertedDataType(new YourConverter());
Field<DayOfWeek> field = DSL.field("{0}", type, lecture.DAY_OF_WEEK);

// And now use that instead
create.select(field)...