List<List<Integer>> matrix = new ArrayList<List<Integer>>();
List<Integer> columnIdsToTransform = Arrays.asList({0, 4, 6 });
// You have to initialize the references; all are null right now.
for (List<Integer> row : matrix) {
    for (int j = 0; j < row.size(); ++j) {            
        // operate on the values here.
        value = row.get(j);
        if (columnsIdsToTransform.contains(j) && (value != 1)) {
            row.set(value-1, j);
        }
    }
}