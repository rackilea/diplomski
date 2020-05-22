private final int GAS_CAP = 30 

public int getGasCapacity()
{
   int gasCapacity;
   if(currentGas <= GAS_CAP)
   {
     gasCapacity = GAS_CAP - currentGas;
   } else {
     gasCapacity = 0;
   }
   return gasCapacity;
}