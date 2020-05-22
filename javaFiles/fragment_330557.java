private Float[][] toFloatArray(float[][] values)
{
   Float[][] objArray = new Float[values.length][];

   for (int i = 0; i < values.length; i++)
   {
      objArray[i] = new Float[values[i].length];
      for (int j = 0; j < values[i].length; j++)
      {
         objArray[i][j] = values[i][j];
      }
   } 

   return objArray;
}