String min = resultsArray[0][2];
for (int i=1; i < resultsArray.length; i++) {
    if (resultsArray[i][2].compareTo(min) < 0) {
        min = resultsArray[i][2];
    }
}
System.out.println(min);