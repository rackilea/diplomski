// somewhere in your code (possibly static?)
double[] _result = { 0, 0.25, 0.5, 1, 2, 4, 8, 16, 32 };

// then your function
public void onProgressChanged (SeekBar seekBar, int progress, boolean fromUser)
{
    // would need to handle if progress is ever > _result.max
    System.out.format("%f%n", _result[progress]);
}