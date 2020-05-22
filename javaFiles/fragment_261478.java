List<String> dateValues = new ArrayList<String>();
Date[] dates = new Date[dateValues.size()];
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
int i = 0;
for (String dateValue : dateValues) {
    dates[i++] = dateFormat.parse(dateValue);
}