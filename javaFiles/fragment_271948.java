FEATUREINFO[] p_featureNode = initializeWithDefaultFEATUREINFOInstances(100);
...

public static FEATUREINFO[] initializeWithDefaultFEATUREINFOInstances(int length)
{
    FEATUREINFO[] array = new FEATUREINFO[length];
    for (int i = 0; i < length; i++)
    {
        array[i] = new FEATUREINFO();
    }
    return array;
}