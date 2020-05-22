Set zeropoint(double a, double b)
{
    double middle = mid point of a and b;
    if a and be less than 0.0001 apart
    {
        if (sin(a) and sin(b) are on opposite sides of 0)
        { 
            return set containing middle
        }
        else
        {
            return empty set
        }
    }
    else
    {
        return union of zeropoint(a, middle) and zeropoint(middle, b)
    }
}