data.toArray();

        double[][] matrix2D = new double[ribet.size()/5][5];

        int k=0;

        for (int i=0; i<data.size()/5; i++) {
            for (int j=0; j<5; j++) {
                matrix2D[i][k%5] = data.get(k);
                k = k+1;
            }
        }