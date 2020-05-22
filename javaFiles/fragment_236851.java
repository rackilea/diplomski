int [][]A = {{1,2,3},{4,5,6},{7,8,9}};

 ArrayList< ArrayList<Integer> > L = new ArrayList< ArrayList<Integer> >();
 for(int i=0; i<3; i++ )
 {
      ArrayList< Integer > la = new ArrayList< Integer >(); 
      for(int j=0; j<3; j++)
      {
          la.add(A[i][j]);
      }
      L.add(la);
  }