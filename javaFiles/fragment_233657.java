String[] daysArr = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
List<String> daysList = Arrays.asList(daysArr);
String input = "Fri";
int index = daysList.indexOf(input);
if (index > 0) {
    Collections.rotate(daysList, -index);
}
System.out.println(daysList);