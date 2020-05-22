public static void main(String[] args) {
    int maxWeight = 50;

    ArrayList<Integer> containerWeights = new ArrayList<Integer>();
    Integer[] weights = new Integer[] { 16, 24, 25, 3, 20, 18, 7, 17, 4, 15, 13, 22, 2, 12, 10, 5, 8, 1, 11, 21, 19, 6, 23, 9, 14 };

    Iterator<Integer> itr = Arrays.asList(weights).iterator();
    int current = itr.next(); //Get the first weight
    int containerWeight = 0;

    while(itr.hasNext()) {
        if(containerWeight + current > maxWeight) {
            containerWeights.add(containerWeight);
            containerWeight = current;
        } else {
            containerWeight += current;
        }
        current = itr.next();
    }
    containerWeights.add(current);
    System.out.println(Arrays.deepToString(containerWeights.toArray()));
}