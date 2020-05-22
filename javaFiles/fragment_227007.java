public static void main(String[] args)
{
   BmiCalculator bmi = new BmiCalculator();
    bmi.getIntro();
    bmi.metricOrImperial();
    bmi.getImperial();
    bmi.getMetric();
    bmi.convertToMetric(); //Added call to converToMetric to calculate height
    bmi.getBmi();
}