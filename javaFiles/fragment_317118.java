public void moveToHead(int[] values, int index)
{
    // TODO: Argument validation
    int value = values[index];
    System.arraycopy(values, 0, values, 1, index - 1);
    values[0] = value;
}