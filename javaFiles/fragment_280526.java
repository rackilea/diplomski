List<DateTime> dtListOld = dt; // your input
List<DateTime> dtListNew = new ArrayList<>();

for (DateTime dateTime : dtListOld) {
  dtListNew.add(dateTime.hourOfDay().roundFloorCopy());
}