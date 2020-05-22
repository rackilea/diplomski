public static double max(Object[] objects, Measurer m)
{
    double largest = 0;
    for (int i=0; i<objects.length; i++)
    {
        if(m.measure(objects[i]) > largest)
        {
            largest = m.measure(objects[i]);
        }
    }
    return largest;
}