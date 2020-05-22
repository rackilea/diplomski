//calculate the minimum 
public double calcMin(double value, double min)
{
    if (min < value)
   {
       min = value;
   }
   return value;
}

//calculate the maximum
public double calcMax(double value, double max)
{
    if (max < value)
    {
        max = value;
    }
   return max;
}