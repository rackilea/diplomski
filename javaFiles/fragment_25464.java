List<List<Integer>> outer=new ArrayList<>();

  for(int i=0;i<5;i++)
  {
     List<Integer> inner=new ArrayList<Integer>();
     for(int j=0;j<10;j++)
     {
       inner.add(0);
     }
     outer.add(inner);
  }