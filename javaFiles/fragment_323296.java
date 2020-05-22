public int multiply(int value1, int value2) 
{
  if (value1 > 1) 
  {
    int remaining = value1 - 1;
    return value2 + multiply(remaining, value2);
  }
  else 
  {
    return value2;
  }
}