public String[] getInkLevel(String[] inkLevels, int position)
{
  for (int i = 0; i < data.get(position).length; i++)
  {
    inkLevels[i] = data.get(position)[i];
  }
  return inkLevels;
}