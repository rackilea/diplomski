public class Lab {
    private double grade;
    private double[] array = new double[10];
    private int insertPoint = 0;

    public void setGrade(double grade) {
        if (insertPoint < array.length) {
            array[insertPoint] = grade;
            insertPoint++;
        }
    }