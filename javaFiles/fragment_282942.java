public class apples {

    public static void main(String[] args) {
        Scanner kenny = new Scanner(System.in);
        double rain[] = new double[12];
        double sum = 0;
        double avg = 0;
        double most = 0;
        double least = 0;

        System.out.println("Your local weather man here getting paid to tell you the wrong weather!!");
        System.out.println("");
        System.out.println("Please enter in the following rainfall for the months ahead: ");
        System.out.println("Month\tRainfall (In inches)");
        System.out.print("January: ");
        rain[0] = kenny.nextDouble();
        System.out.print("February: ");
        rain[1] = kenny.nextDouble();
        System.out.print("March: ");
        rain[2] = kenny.nextDouble();
        System.out.print("April: ");
        rain[3] = kenny.nextDouble();
        System.out.print("May: ");
        rain[4] = kenny.nextDouble();
        System.out.print("June: ");
        rain[5] = kenny.nextDouble();
        System.out.print("July: ");
        rain[6] = kenny.nextDouble();
        System.out.print("August: ");
        rain[7] = kenny.nextDouble();
        System.out.print("September: ");
        rain[8] = kenny.nextDouble();
        System.out.print("October: ");
        rain[9] = kenny.nextDouble();
        System.out.print("November: ");
        rain[10] = kenny.nextDouble();
        System.out.print("December: ");
        rain[11] = kenny.nextDouble();

        //(Or rain[] = 1,2,3,4,5,6,7,8,9,10,11,12);
        sum = rain[0] + rain[1] + rain[2] + rain[3] + rain[4] + rain[5] + rain[6] + rain[7] + rain[8] + rain[9] + rain[10] + rain[11];
        avg = sum / 12;

        System.out.println("The sum of all the rain is: " + sum);
        System.out.println("The average rainfall was:" + avg + " inches");
        most =getMaxValue(rain);
        least=getMinValue(rain);
        System.out.println("The max rain is: " + most);
        System.out.println("The min rain is: " + least);

    }

    private static double getMaxValue(double[] rain) {
        double max = 0;
        for (double i : rain) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    private static double getMinValue(double[] rain) {

        double min = Double.MAX_VALUE;
        for (double i : rain) {
                        System.out.println(i);
            if (i < min) {
                min = i;
            }
        }
        System.out.println(min);
        return min;
    }
}