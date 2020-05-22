public static void printDatesAndAmts(String[] dates, double[] amt){
    ArrayList<String> datesWithoutDuplicates = new ArrayList<String>();
    ArrayList<String> datesChecked = new ArrayList<String>();
    ArrayList<Double> totals = new ArrayList<Double>();
    ArrayList<Integer> indexDuplicatesFound = new ArrayList<>();

    for (int i = 0; i < dates.length; i++){
        String tempDateItem = dates[i];
        double tempAmt = 0.0;
        for (int j = 0; j < dates.length; j++){
            if (tempDateItem.equals(dates[j]) && !(datesChecked.contains(tempDateItem))){
                indexDuplicatesFound.add(j);
                tempAmt += amt[j];
            }
        }
        if (!(datesWithoutDuplicates.contains(tempDateItem))){
            datesWithoutDuplicates.add(tempDateItem);
            totals.add(tempAmt);
        }
        datesChecked.add(tempDateItem);
        indexDuplicatesFound.clear();
    }

    for (int i = 0; i < datesWithoutDuplicates.size(); i++){
        System.out.println(datesWithoutDuplicates.get(i));
        System.out.println(totals.get(i));
    }
}