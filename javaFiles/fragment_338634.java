private ArrayList<SoftDrink> sort(boolean isAscending){
    ArrayList<SoftDrink> copy = new ArrayList<>(originalList); // creates a copy of your original list
    Comparator<SoftDrink> ascendingComparator = new Comparator<SoftDrink>() {
        @Override
        public int compare(SoftDrink a, SoftDrink b) {
            return a.getPrice() - b.getPrice();
        }
    };
    if (isAscending) {
        copy.sort(ascendingComparator);
    } else {
        copy.sort(Collections.reverseOrder(ascendingComparator));
    }

    return copy;
}