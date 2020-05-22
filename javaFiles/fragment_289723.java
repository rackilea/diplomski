String[] objs = { "2", "07.16", "3", "08.16", "2", "10.16", 
                  "1", "11.16", "1", "12.16", "1", "01.17" };
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.yy");
NavigableMap<YearMonth, Integer> quantities = new TreeMap<>();
for (int i = 0; i < objs.length; i += 2) {
  quantities.put(YearMonth.from(formatter.parse(objs[i + 1])), Integer.valueOf(objs[i]));
}
String[] result;
if (quantities.isEmpty()) {
  result = new String[0];
} else {
  YearMonth lowest = quantities.firstKey();
  YearMonth highest = quantities.lastKey();
  int months = (int) ChronoUnit.MONTHS.between(lowest, highest) + 1;
  result = new String[months * 2];
  for (int i = 0; i < months; i++) {
    YearMonth ym = lowest.plusMonths(i);
    result[i * 2] = quantities.getOrDefault(ym, 0).toString();
    result[i * 2 + 1] = formatter.format(ym);
  }
}
System.out.println(Arrays.toString(result));