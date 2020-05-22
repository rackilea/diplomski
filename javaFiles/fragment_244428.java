public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            l.add(i, new ArrayList<Integer>());
            for (int j = 0; j <= i; j++){
                l.get(i).add((int) biCoeff(numRows, j));
            }
        }
        return l;
    }