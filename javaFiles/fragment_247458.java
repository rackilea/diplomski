public void rotateArray(Object[] array, int index)
{
    Object[] result;

    result = new Object[array.length];

    System.arraycopy(array, index, result, 0, array.length - index);
    System.arraycopy(array, 0, result, array.length - index, index);

    System.arraycopy(result, 0, array, 0, array.length);
}