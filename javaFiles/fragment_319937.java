DateTime start = // whatever
DateTime end = // whatever

List<DateTime> datesBetween = new ArrayList<DateTime>();

while (start <= end) {
   datesBetween.add(start);
   DateTime dateBetween = start.plusWeeks(1);
   start = dateBetween;
}