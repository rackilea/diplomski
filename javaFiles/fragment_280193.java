import javax.swing.JOptionPane;

    public class Exer1Sano_an {
        public static void main(String[] args) {
            String L = null, W = null;
            String x = null;
            choice(x);
            measureW(W);
            measureL(L);

            processing();

            System.exit(0);
        }// end of main meathod

        // for length and width
        public static String measureW(String W) {
            W = JOptionPane.showInputDialog("Enter the Width: ");
            return W;
        }

        public static String measureL(String L) {
            L = JOptionPane.showInputDialog("Enter the Length: ");
            return L;

        }

        // for chioce
        public static String choice(String x) {
            x = JOptionPane
                    .showInputDialog("n\1. Perimiter of a Rectangle n\2. Area of        Rectangle n\3. Measurement of the Diagonals of a Rectangle");
            return x;
        }

        // for computation and printing
        public static void processing() {
            int areaRect = 0;
            int periRect = 0;
            double diagNal = 0;
            int L2 = 0, W2 = 0;
            int x2 = 0;

            if (x2 == 1)
                periRect = (2 * L2) + (2 * W2);
            JOptionPane.showMessageDialog(null,
                    "The perimiter of your     rectanlge is" + periRect);

            if (x2 == 2)
                areaRect = L2 * W2;
            JOptionPane.showMessageDialog(null, "The area of your rectanlge is"
                    + areaRect);

            if (x2 == 3)
                diagNal = Math.sqrt((L2 * L2) + (W2 * W2));
            JOptionPane.showMessageDialog(null,
                    "The measurement of the diagonals of your recangle is"
                            + diagNal);

        }

    }// end of class