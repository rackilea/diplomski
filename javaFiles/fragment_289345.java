public Matrix getS () {
      Matrix X = new Matrix(n,n);
      double[][] S = X.getArray();
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            S[i][j] = 0.0;
         }
         S[i][i] = this.s[i];
      }
      return X;
   }