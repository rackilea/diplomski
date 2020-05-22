public boolean checkValues()
{
  int numCounter=1;
  boolean okay=false;
  while (numCounter<=n*n)
  {
     ok = false;
     for (int i=0; i< n ; i++) 
     {
        for (int j=0; j< n ; j++)
        {
           if ((int) square.get(i).get(j)==numCounter)
              ok=true;  
        }
     }
     if(!ok)  // numCounter cannot be found
         return false;
     numCounter++;
  }
  return true; // successfully passed the check through 1 to n^2 
}