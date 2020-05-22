public class SO6026472 {

    public static void main(String[] args) {
        // define individual tables
        Integer[] t1 = new Integer[] {2,-2,4,7};
        Integer[] t2 = new Integer[] {3,-3,-8,0};
        Integer[] t3 = new Integer[] {-1,-4,-7,6};
        Integer[] t4 = new Integer[] {1,5};
        // build list of tables
        List<List<Integer>> tables = new ArrayList<List<Integer>>();
        tables.add(Arrays.asList(t1));
        tables.add(Arrays.asList(t2));
        tables.add(Arrays.asList(t3));
        tables.add(Arrays.asList(t4));
        // find solutions
        SO6026472 c = new SO6026472();
        List<List<Integer>> solutions = c.find(36, tables);
        for (List<Integer> solution : solutions) {
            System.out.println(
                    Arrays.toString(solution.toArray(new Integer[0])));
        }
    }

    /**
     * Computes the ways of computing p as a product of elements taken from 
     * every table in tables.
     * 
     * @param p the target product value
     * @param tables the list of tables
     * @return the list of combinations of elements (one from each table) whose
     * product is equal to p
     */
    public List<List<Integer>> find(int p, List<List<Integer>> tables) {
        List<List<Integer>> solutions = new ArrayList<List<Integer>>();
        // if we have no tables, then we are done
        if (tables.size() == 0)
            return solutions;
        // if we have just one table, then we just have to check if it contains p
        if (tables.size() == 1) {
            if (tables.get(0).contains(p)) {
                List<Integer> solution = new ArrayList<Integer>();
                solution.add(p);
                solutions.add(solution);
                return solutions;
            } else
                return solutions;
        }
        // if we have several tables, then we take the first table T, and for
        // every value v in T we search for (p / v) in the rest of the tables;
        // we do this only if p % v is equal to 0, because we're dealing with
        // ints
        List<Integer> table = tables.remove(0);
        for (Integer value : table) {
            if (value != 0 && p % value == 0) {
                List<List<Integer>> subSolutions = find(p / value, tables);
                if (! subSolutions.isEmpty()) {
                    for (List<Integer> subSolution : subSolutions) {
                        subSolution.add(0, value);
                    }
                    solutions.addAll(subSolutions);
                }
            }
        }
        tables.add(0, table);
        return solutions;
    }

}