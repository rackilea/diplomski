class ModeArray
{
    public static void main(String[] args) {
        double[] numRead = { 1, 2, 3, 3, 4, 4, 4, 5, 0, 0, 0, 0, 0 };
        System.out.println(modeCalc(numRead, 8));
    }

    public static double modeCalc(double[] numRead, int num) {
        double maxValue = numRead[0];
        int maxCount = 0;
        for (int i = 0; i < num; i++) {
            int count = 0;
            for (int j = 0; j < num; j++) {
                if (numRead[j] == numRead[i]){
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = numRead[i];
            }
        }
        return maxValue;
    }
}