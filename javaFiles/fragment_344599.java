// every car is a String[3]
String[][] cars = loadCars();
Comparator<String[]> skodaCarComparator = new Comparator<String[]>() {
    @Override
    public int compare(String[] o1, String[] o2) {
        // compares the numbers as Strings using String's compareTo()
        return o1[2].compareTo(o2[2]);
    }
}; 
Arrays.sort(cars, skodaCarComparator);