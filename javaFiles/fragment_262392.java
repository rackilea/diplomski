public static double[] alterRedNoise(double[] input, int startIndex, int interpolationNumber)
{
        int k = startIndex;
        int l = ((startIndex + interpolationNumber)<input.length-1?(startIndex+interpolationNumber):input.length-1);
        double d = (input[l] - input[k])/((double)(interpolationNumber));
        for (int j=0; j<interpolationNumber; j++) {
            input[k+j] = input[k] + d*j;
        }
    return input;
}