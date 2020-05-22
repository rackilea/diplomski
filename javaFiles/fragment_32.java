List<Integer> yearsList = new ArrayList<Integer>();
for (int i = 0; i < rainfallYears.length; i++) {
    yearsList.add(new RainfallYear(i, null).getYear());
}

int[] yearsArray = new int[yearsList.size()];
for (int i = 0; i < yearsList.size(); i++) {
    yearsArray[i] = yearsList.get(i);
}

return yearsArray;