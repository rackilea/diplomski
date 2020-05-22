private Float[][] toFloatArray(float[][] values)
{
   Float[][] objArray = new Float[values.length][];

   for (int i = 0; i < values.length; i++)
   {
      float[] subSource = values[i];
      Float[] subDest = new Float[subSource.length];
      objArray[i] = subDest;
      for (int j = 0; j < subSource.length; j++)
      {
         subDest[j] = subSource[j];
      }
   } 

   return objArray;
}