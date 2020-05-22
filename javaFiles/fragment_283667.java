int[][] ids = new int[][]{
              {R.id.R0C0, R.id.R0C1, R.id.R0C2},
              {R.id.R1C0, R.id.R1C1, R.id.R1C2},
              {R.id.R2C0, R.id.R2C1, R.id.R2C2}};

 for (int i = 0; i < 3; i++)
     for (int j = 0; j < 3; j++)
         g[i][j] = (Button) findViewById(ids[i][j]);