public void onProgressChanged (SeekBar seekBar, int progress, boolean fromUser)
{
    // get the 'max' of our bar
    double max = (double)seekBar.getMax(); // 8
    // get the 'max' of our 'array' values, this could be a const value
    // or some other formula (like max * 4f)
    double pmax = 32;
    // get our 'mask' by shifting '1' left 'progress' times, then divide by 2
    // to get the divisor to our other formula
    double p = (double)(1 << progress) / 2; 
    // if progress == 0, then just return 0 (since that's our min)
    double val = ((progress == 0) ? 0 : (max / (pmax / p)));

    // the 'one-liner': 
    // ((double)seekBar.getMax()) / (pmax / ((double)(1 << progress) / 2)))

    System.out.format("%f%n", val);
}