for (int a = 0; a < list.size(); a++){

  if(list.get(a) ==100)
  {
      Array[9] +=1; 
  }else
  {
      Array[list.get(a)/10] +=1; 
      System.out.println(Arrays.toString(Array));
  }

  }