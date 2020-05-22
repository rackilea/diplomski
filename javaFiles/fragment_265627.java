import javax.swing.*;
import java.util.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.lang.Object;
import java.lang.Math;

class Matrix {
   public double[][] times(double[][] A, double[][] B) {
      if (A[0].length == B.length) {
         int i, j, k;
         int m = A.length;
         int n = A[0].length;
         int q = B[0].length;
         double[][] C;
         double[] e;
         C = new double[m][q];
         e = new double[n];
         for (i = 0; i <= m - 1; i++) {
            // System.out.println();
            for (k = 0; k <= q - 1; k++) {
               for (j = 0; j <= n - 1; j++) {
                  e[j] = A[i][j] * B[j][k];
                  C[i][k] = C[i][k] + e[j];
               }
               // System.out.print(C[i][k]+"                    ");
            }
         }
         // System.out.println(m+"@"+n+"@"+q);
         return C;
      } else {
         throw new RuntimeException("Illegal matrix dimensions.");
      }
   }

   // This method calculates the coordinates of Cube's dots
   public double[][] dots(double[] angle, String dot) {
      double[][] turnX = {
            { 1, 0, 0 },
            { 0, Math.cos(Math.toRadians(angle[0])),
                  (-1 * (Math.sin(Math.toRadians(angle[0])))) },
            { 0, Math.sin(Math.toRadians(angle[0])),
                  Math.cos(Math.toRadians(angle[0])) } };
      double[][] turnY = {
            { Math.cos(Math.toRadians(angle[1])), 0,
                  Math.sin(Math.toRadians(angle[1])) },
            { 0, 1, 0 },
            { (-1 * (Math.sin(Math.toRadians(angle[1])))), 0,
                  Math.cos(Math.toRadians(angle[1])) } };
      double[][] turnZ = {
            { Math.cos(Math.toRadians(angle[2])),
                  (-1 * (Math.sin(Math.toRadians(angle[2])))), 0 },
            { Math.sin(Math.toRadians(angle[2])),
                  Math.cos(Math.toRadians(angle[2])), 0 }, { 0, 0, 1 } };
      double[][][] dots = { { { 0 }, { 0 }, { 0 } }, { { 0 }, { 100 }, { 0 } },
            { { 100 }, { 100 }, { 0 } }, { { 100 }, { 0 }, { 0 } },
            { { 100 }, { 0 }, { 100 } }, { { 0 }, { 0 }, { 100 } },
            { { 0 }, { 100 }, { 100 } }, { { 100 }, { 100 }, { 100 } } };

      double[][] oMat = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
      double[][] am = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

      Matrix mx = new Matrix();

      if (angle[0] != 0 || angle[1] != 0 || angle[2] != 0) {
         if (angle[0] != 0 && angle[1] != 0 && angle[2] != 0) {
            double[][] res = mx.times(turnX, turnY);
            am = mx.times(res, turnZ);
         } else if (angle[0] != 0 && angle[1] != 0 && angle[2] == 0) {
            am = mx.times(turnX, turnY);
         } else if (angle[0] != 0 && angle[1] == 0 && angle[2] != 0) {
            am = mx.times(turnX, turnZ);
         } else if (angle[0] != 0 && angle[1] == 0 && angle[2] == 0) {
            am = turnX;
         } else if (angle[0] == 0 && angle[1] != 0 && angle[2] != 0) {
            am = mx.times(turnY, turnZ);
         } else if (angle[0] == 0 && angle[1] != 0 && angle[2] == 0) {
            am = turnY;
         } else if (angle[0] == 0 && angle[1] == 0 && angle[2] != 0) {
            am = turnZ;
         }

         if (dot == "a") {
            double[][] A3d = mx.times(am, dots[0]);
            double[][] A = mx.times(oMat, A3d);
            return A;
         } else if (dot == "b") {
            double[][] B3d = mx.times(am, dots[1]);
            double[][] B = mx.times(oMat, B3d);
            return B;
         } else if (dot == "c") {
            double[][] C3d = mx.times(am, dots[2]);
            double[][] C = mx.times(oMat, C3d);
            return C;
         } else if (dot == "d") {
            double[][] D3d = mx.times(am, dots[3]);
            double[][] D = mx.times(oMat, D3d);
            return D;
         } else if (dot == "e") {
            double[][] E3d = mx.times(am, dots[4]);
            double[][] E = mx.times(oMat, E3d);
            return E;
         } else if (dot == "f") {
            double[][] F3d = mx.times(am, dots[5]);
            double[][] F = mx.times(oMat, F3d);
            return F;
         } else if (dot == "g") {
            double[][] G3d = mx.times(am, dots[6]);
            double[][] G = mx.times(oMat, G3d);
            return G;
         } else if (dot == "h") {
            double[][] H3d = mx.times(am, dots[7]);
            double[][] H = mx.times(oMat, H3d);
            return H;
         } else {
            throw new RuntimeException("Illegal dot name.");
         }
      } else {
         throw new RuntimeException("Zero angles.");
      }

   }
}

class Paint extends JPanel {
   public void paint(Graphics g) {
      // Angles { X , Y , Z}
      double[] angle = { 35.264, 45, 0 };
      Matrix mx = new Matrix();
      double[][] A = mx.dots(angle, "a");
      double[][] B = mx.dots(angle, "b");
      double[][] C = mx.dots(angle, "c");
      double[][] D = mx.dots(angle, "d");
      double[][] E = mx.dots(angle, "e");
      double[][] F = mx.dots(angle, "f");
      double[][] G = mx.dots(angle, "g");
      double[][] H = mx.dots(angle, "h");

      Dimension size = getSize();
      int w = (size.width) / 2;
      int t = (size.height) / 2;
      Graphics2D g2 = (Graphics2D) g;
      super.paint(g);
      for (int i = 0; i <= 360; i++) {
         angle[2] = i;
         g2.draw(new Line2D.Double((w + A[0][0]), (t + (-1 * (A[1][0]))),
               (w + B[0][0]), (t + (-1 * (B[1][0])))));
         g2.draw(new Line2D.Double((w + B[0][0]), (t + (-1 * (B[1][0]))),
               (w + C[0][0]), (t + (-1 * (C[1][0])))));
         g2.draw(new Line2D.Double((w + C[0][0]), (t + (-1 * (C[1][0]))),
               (w + D[0][0]), (t + (-1 * (D[1][0])))));
         g2.draw(new Line2D.Double((w + D[0][0]), (t + (-1 * (D[1][0]))),
               (w + A[0][0]), (t + (-1 * (A[1][0])))));
         g2.draw(new Line2D.Double((w + A[0][0]), (t + (-1 * (A[1][0]))),
               (w + F[0][0]), (t + (-1 * (F[1][0])))));
         g2.draw(new Line2D.Double((w + B[0][0]), (t + (-1 * (B[1][0]))),
               (w + G[0][0]), (t + (-1 * (G[1][0])))));
         g2.draw(new Line2D.Double((w + C[0][0]), (t + (-1 * (C[1][0]))),
               (w + H[0][0]), (t + (-1 * (H[1][0])))));
         g2.draw(new Line2D.Double((w + D[0][0]), (t + (-1 * (D[1][0]))),
               (w + E[0][0]), (t + (-1 * (E[1][0])))));
         g2.draw(new Line2D.Double((w + E[0][0]), (t + (-1 * (E[1][0]))),
               (w + F[0][0]), (t + (-1 * (F[1][0])))));
         g2.draw(new Line2D.Double((w + F[0][0]), (t + (-1 * (F[1][0]))),
               (w + G[0][0]), (t + (-1 * (G[1][0])))));
         g2.draw(new Line2D.Double((w + G[0][0]), (t + (-1 * (G[1][0]))),
               (w + H[0][0]), (t + (-1 * (H[1][0])))));
         g2.draw(new Line2D.Double((w + H[0][0]), (t + (-1 * (H[1][0]))),
               (w + E[0][0]), (t + (-1 * (E[1][0])))));
         // Timer timer = new Timer(100);
         // timer.start();
         try {
            Thread.sleep(10);
         } catch (InterruptedException ie) {
         }
         this.repaint();
         // setFocusable(true);

      }
   }
}

public class Cube {

   public static void main(String[] args) {
      JFrame frame = new JFrame("Malakhovskyi BS11-01");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(new Paint());
      frame.pack();
      frame.setSize(640, 480);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);

   }
}