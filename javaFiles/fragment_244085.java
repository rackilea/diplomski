public String[] reproduce(String[] father, String[] mother) {
  int[] child=new String[father.length];
  int crossPoint = Math.random()*father.length;//make a crossover point
  for (int i=0;i<father.length;++i)
  {
    if (i<crossPoint)
      child[i]=father[i];
    else
      child[i]=mother[i];
  }
  return child;
}