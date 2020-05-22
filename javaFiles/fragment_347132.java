for (int i=0; i<2; i++) {
    for (int j=0; j<2; j++) {
        if (path[i][j] == 0) {
            path[i][j] = 1;

            // here
            int[][] copy = new int[2][2];
            for(int k=0; k<2; k++) {
                copy[k] = path[k].clone();
            }

            q.add(copy);

            path[i][j] = 0; // now, this does not affect the added element
        }
    }
}