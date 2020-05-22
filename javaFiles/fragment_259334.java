private static int[] s_counter = new int[1024];
private void UpdateCounter(int position)
{
    for (int j = 0; j < 100000000; j++)
    {
        s_counter[position] = s_counter[position] + 3;
    }
}