for(i=0;i<frequency.size();i++)
{
      v=frequency.get(i);
      if(v<min_sup)
      {
          uniqueitems.remove(i);
          frequency.remove(i);
          System.out.println(uniqueitems.get(i)+ " is inside if.");
          i--;
      }
      else
      {
          System.out.println(uniqueitems.get(i)+ " is not in if.");
      }  
}