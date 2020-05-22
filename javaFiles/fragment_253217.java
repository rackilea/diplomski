public static int classify(ImageMatrixDB trainingSet, int[] curData, int k) {
    int label = 0, bestDistance = Integer.MAX_VALUE;
    int[][] distances = new int[trainingSet.size()][2];
    int i=0;

    // Place distances in an array to be sorted
    for(ImageMatrix matrix: trainingSet) {
        distances[i][0] = distance(matrix.getData(), curData);
        distances[i][1] = matrix.getClassCode();
        i++;
    }

    Arrays.sort(distances, (int[] lhs, int[] rhs) -> lhs[0]-rhs[0]);

    // Find frequencies of each class code
    i = 0;
    Map<Integer,Integer> majorityMap;
    majorityMap = new HashMap<Integer,Integer>();
    while(i < k) {
        if( majorityMap.containsKey( distances[i][1] ) ) {
            int currentValue = majorityMap.get(distances[i][1]);
            majorityMap.put(distances[i][1], currentValue + 1);
        }
        else {
            majorityMap.put(distances[i][1], 1);
        }
        ++i;
    }

    // Find the class code with the highest frequency
    int maxVal = -1;
    for (Entry<Integer, Integer> entry: majorityMap.entrySet()) {
        int entryVal = entry.getValue();
        if(entryVal > maxVal) {
            maxVal = entryVal;
            label = entry.getKey();
        }
    }

    return label;
}