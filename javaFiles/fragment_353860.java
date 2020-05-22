String dbFormat = AppConstant.DB_DATE_FORMAT;
String format = AppConstant.DATE_FORMAT;
SimpleDateFormat df = new SimpleDateFormat(format);
SimpleDateFormat df2 = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
df.setTimeZone(TimeZone.getTimeZone("UTC"));
String dates[] = searchValue.split("_", -1);
String start = "".equals(dates[0]) ? df.format(new Date(0L)) : df.format(df2.parse(dates[0]));
String end = "".equals(dates[1]) ? df.format(new Date()) : df.format(df2.parse(dates[1]));
filters.add(String.format("%s between to_date('%s', '%s') and to_date('%s', '%s')", columnKey, start, dbFormat, end, dbFormat))