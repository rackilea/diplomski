public static void main(String[] args) {
                // write your code here
                double[] tomb;
                int max = 10;
                tomb = new double[max];
                for (int i = 0; i < max; i++) {
                        tomb[i] = i * 1.65223;
                }
                System.out.println("Minimum: " + getMin(tomb));
                System.out.println("Maximum: " + getMax(tomb));
                System.out.println("Average: " + getAverage(tomb));
        }

        private static double getMin(double[] tomb) {
                double min = tomb[0];
                for (double d:tomb) {
                        if (d < min) {
                                min = d;
                        }
                }
                return min;
        }

        private static double getMax(double[] tomb) {
                double max = tomb[0];
                for (double d:tomb) {
                        if (d > max) {
                                max = d;
                        }
                }
                return max;
        }
        private static double getAverage(double[] tomb) {
                double avg = 0;
                for (double d:tomb) {
                        avg+=d;
                }
                return avg/tomb.length;
        }