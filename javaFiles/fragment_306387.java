boolean isOneDimensional(Object[] array)
{
    // Assuming you want an NPE if `array` is `null`, so not checking
    for (int i=0; i<array.length; i++)
        if (array[i] != null && array[i].getClass().isArray()) return false;
    return true;
}