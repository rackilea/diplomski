public short[] HanningWindow(short[] signal_in, int pos, int size)
{
    for (int i = pos; i < pos + size; i++)
    {
        int j = i - pos; // j = index into Hann window function
        signal_in[i] = (short) (signal_in[i] * 0.5 * (1.0 - Math.cos(2.0 * Math.PI * j / size)));
    }
    return signal_in;
}