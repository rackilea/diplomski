import java.io.*;
public strictfp class fptest {
 public static double calc(int k) {
  double a = 2.0;
  double b = 1.0;
  for (int i = 0; i < k; i++) {
   b *= a;
  }
  return b;
 }
 public static double intest() {
  double d = 0;
  for (int i = 0; i < 4100; i++) d += calc(i);
  return d;
 }
 public static void main(String[] args) throws Exception {
  for (int i = 0; i < 100; i++)
   System.out.println(intest());
 }
}