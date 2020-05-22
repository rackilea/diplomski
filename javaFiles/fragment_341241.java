double average = ((double) sum) / listOfInt.length;// sum divided by 10
System.out.printf("Average: %.2f%n",  average);
List<Integer> aboveAverage = new ArrayList<>();
for (int v : listOfInt) {
    if (v > average) {
        aboveAverage.add(v);
    }
}
System.out.printf("There are %d numbers above the average%n",
        aboveAverage.size());
System.out.printf("Those numbers are: %s%n", aboveAverage);