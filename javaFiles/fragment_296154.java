final DateFormat df = new SimpleDateFormat("d-MMM-yyyy", Locale.US);

final Date begin = df.parse("5-Feb-2011");
final Date end = df.parse("2-March-2011");

final List<Date> range = dayRange(begin, end);
final Map<String, Long> result = // code to execute your query

for (Date date: range) {
    String key = df.format(date);
    if(!result.containsKey(key)) {
        result.put(key, 0l);
    }
}