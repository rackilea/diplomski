for(int i = 0 ; i < array.Length; i++)
{

    if (float.IsInfinity(array[i]) || float.IsNaN(array[i]))
    {
        array[i] = 0;
    }
}