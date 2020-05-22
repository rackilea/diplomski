public static int priceisRight(int bids[], int price)
{
   int closest = 0;
   for(int i=0; i< bids.length; i++)
   {
      if(closest<bids[i] && bids[i]<=price)
      {
        closest=bids[i];
      }
   }
   return closest;
}