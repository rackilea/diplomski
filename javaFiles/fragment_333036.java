List<String> listOfMonth = new LinkedList<>();
int[] offset = { 9, 10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8 };
String[] months = new DateFormatSymbols().getShortMonths();
for (int i = 0; i < offset.length; i++) {
    listOfMonth.add(months[offset[i] - 1]);
}
System.out.println(listOfMonth);