// create a table with 7 columns
table = new PdfPTable(7);
table.setTotalWidth(504);
// add the name of the month
table.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
table.addCell(getMonthCell(calendar, locale));
int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
int day = 1;
int position = 2;
// add empty cells
while (position != calendar.get(Calendar.DAY_OF_WEEK)) {
    position = (position % 7) + 1;
    table.addCell("");
}
// add cells for each day
while (day <= daysInMonth) {
    calendar = new GregorianCalendar(year, month, day++);
    table.addCell(getDayCell(calendar, locale));
}
// complete the table
table.completeRow();