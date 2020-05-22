public static void sw(int[] l, int i,int j)
  {
    for(; i<=j;i++, j--)
    {
      int temp = l[i];
      l[i] = l[j];
      l[j] = temp;
    }
  }