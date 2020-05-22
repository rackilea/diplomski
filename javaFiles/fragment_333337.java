//sort the item  to show months in ascending order
Collections.sort(items, new Comparator<PastMonthsWeightStats>(){
    @Override
    public int compare(PastMonthsWeightStats obj1, PastMonthsWeightStats obj2) {
        // ## Ascending order
        // return obj1.firstName.compareToIgnoreCase(obj2.firstName); // To compare string values
        //return Float.valueOf(obj1.getMonthNumber()).compareTo(Float.valueOf(obj2.getMonthNumber())); // To compare integer values

        // ## Descending order
        // return obj2.firstName.compareToIgnoreCase(obj1.firstName); // To compare string values
        return Integer.valueOf(obj2.getMonthNumber()).compareTo(Integer.valueOf(obj1.getMonthNumber())); // To compare integer values
    }
});