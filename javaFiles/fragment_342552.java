public static void main(String[] args) {
    int xBound = 3;
    int yBound = 3;
    String[][] grid = new String[][] {
        {"A", "B", "A"},
        {"A", "B", "B"},
        {"A", "A", "B"} 
    };

    for(int i = 0; i < yBound; i++) {
        for(int j = 0; j < xBound; j++) {
            String state = grid[i][j];
            List<List<Integer>> group = getGroup(state, j, i, xBound, yBound, grid);
            if (group.size() != 0) {
                System.out.println(state + " " + group);
            }   
        }
    }
}

static List<List<Integer>> getGroup(String state, int xIndex, int yIndex, int xBound, int yBound, String[][] grid) {
    if (xIndex >= xBound || xIndex < 0 || yIndex >= yBound || yIndex < 0 || grid[yIndex][xIndex].equals("USED")) {
        return new ArrayList<>();
    } else if (grid[yIndex][xIndex].equals(state)){
        grid[yIndex][xIndex] = "USED";

        List<List<Integer>> ourPosse = new ArrayList<List<Integer>>();
        ourPosse.add(Arrays.asList(yIndex, xIndex));
        ourPosse.addAll(getGroup(state, xIndex + 1, yIndex, xBound, yBound, grid));
        ourPosse.addAll(getGroup(state, xIndex - 1, yIndex, xBound, yBound, grid));
        ourPosse.addAll(getGroup(state, xIndex, yIndex + 1, xBound, yBound, grid));
        ourPosse.addAll(getGroup(state, xIndex, yIndex - 1, xBound, yBound, grid));

        return ourPosse;
    } else {
        return new ArrayList<>();
    }
}