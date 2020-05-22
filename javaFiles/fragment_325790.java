double[][] deinterleaveData(double[] samples, int numChannels)
{
   // assert(samples.length() % numChannels == 0);
   int numFrames  = samples.length() / numChannels;

   double[][] result = new double[numChannels][];
   for (int ch = 0 ; ch < numChannels ; ch++)
   {
       result[ch] = new double[numFrames];
       for (int i = 0 ; i < numFrames ; i++)
       {
           result[ch][i] = samples[numChannels*i+ch];
       }
   }
   return result;
}