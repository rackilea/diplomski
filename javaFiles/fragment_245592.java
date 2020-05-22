private void printNumbers(Map<Integer, Integer> intOccurences, int minTotal, int maxTotal){
    boolean first = false;
    System.out.print("{");
    for (Map.Entry<Integer, Integer> entry : intOccurences.entrySet()) {
        int total = entry.getValue();
        if (total >= minTotal && total <= maxTotal) {
            if (first) {
                first = false;
            } else {
                System.out.print(", ");
            }
            System.out.print(entry.getKey() + "=" + total);
        }
    }
    System.out.print("}");
}