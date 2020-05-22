public static boolean AreAllSame(String[] array)
{
    boolean isFirstElementNull = array[0] == null;
    for(int i = 1; i < array.length; i++)
    {
        if(isFirstElementNull)
            if(array[i] != null) return false;
        else 
            if(!array[0].equals(array[i])) return false;
    }

    return true;
}