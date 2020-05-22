void countOcc(int []arr) {  
    Set<Integer> uniques = new LinkedHashSet<Integer>();
    for(int x : arr) {
        uniques.add(x);
    }

    for(int y : uniques) {
        int totalOcc = Collections.frequency(Arrays.asList(arr), y);
        //gives total occurences for each unique element in the array
    }
}