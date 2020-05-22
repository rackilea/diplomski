ArrayList<String> concatenated = new ArrayList<>();
String[] months = getResources().getStringArray(R.string.month);
String[] numbers = getResources().getStringArray(R.string.monthN);
for(int i = 0; i < months.length; i++) {
    concatenated.add(numbers[i] + " " + months[i]);
}