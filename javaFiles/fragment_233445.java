public static makeNeighbours(Family... families)
{
   for (int i = 1; i < families.length; i++)
   {
      families[i-1].rightNeighbour = families[i];
      families[i].leftNeighbour = families[i-1];
   }
}