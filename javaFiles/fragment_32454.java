public static int[][] makeStandardForm(int[][] m){
    //generate list of index swaps
    List<Integer> l = new ArrayList<Integer>(orderIndexes(m));
    int[][] m1 = new int[m.length][m.length];
    int[][] m2 = new int[m.length][m.length];

    //Swap rows, working fine
    for(int i=0; i < m.length; i++){
        m1[i] = m[(int)l.get(i)];
    }

    //Swap columns, stuck here?
    for(int i=0; i < m.length; i++){
        for (int j = 0; j < m.length; j++) { // I used the fact that matrix is square here
            m2[j][i] = m1[j][l.get(i)];
        }
    }
    return m2;
}