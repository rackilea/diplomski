int[][][] getCopy(int[][][] bands)
{
  int[][][] newBands = new int[bands.length][][];
  for (int i = 0; i < bands.length; i++)
  {
    newBands[i] = new int[bands[i].length];
    for (int j = 0; j < bands[i].length; j++)
    {
      newBands[i][j] = new int[bands[i][j].length];
      System.arraycopy(bands, 0, newBands, 0, bands[i][j].length))
    }
  }
  return newBands;
}

// to add
bandsList.add(getCopy(bands));