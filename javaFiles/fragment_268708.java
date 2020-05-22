public double firstPastAsk(int rowIn)    
{
   ...
   String primaryResult = primary(rowIn);
   System.out.println(trajectory(rowIn) + " " + primaryResult + " " + finalAction(primaryResult));

   return pastPrice;
}

public String finalAction(String primaryResult)
{   
    action = "[" + primaryResult + "]";
    return action ;
}