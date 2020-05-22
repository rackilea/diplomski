public double getDoubleOrDefault(String value, double defValue)
{
    try
    {
        return Double.parseDouble(value);
    }
    catch (Exception ex)
    {
        return defValue;
    }
}

txb1 = getDoubleOrDefault(tb1, 0.0);