for(int x =0; x< cartas.length;x++)
{
      if(cartas[x].isEnabled()) //enabled
      {
         break; //a button is still enabled so cancel loop
      }
      else if(x == cartas.length-1&& !cartas[x].isEnabled())
       {
            //All cards have been disabled. Do Something.
       } 
}