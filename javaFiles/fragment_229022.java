int[] a= {3,2,3,2,2, 2, 4, 4, 5 ,5};
        int count = 1, tempCount;
        int repeated = a[0];
       int temp = 0;
       for (int i = 0; i < (a.length - 1); i++)
        {
       temp = a[i];
       tempCount = 0;
      for (int j = 0; j < a.length; j++)
    {
      if (temp == a[j])
        tempCount++;
    }
    if (tempCount ==count )
    {
        if(temp>repeated ){

     repeated = temp;
      count = tempCount;
        }
    }
    if (tempCount > count)
    {
     repeated = temp;
      count = tempCount;
    }
  }
    System.out.println(repeated);
    }
}