import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.*;

public class Prime {
 public static void main(String[] args) {
  int maxCount = 100;
  int[] values = new int[maxCount];
  int temp = 3;
  int val_cnt = 0;
  values[val_cnt++] = 2;
  System.out.println(2);
  for (int j = 3; val_cnt < maxCount; ++j) {
   boolean prime = true;
   if (j % 2 == 0)
    prime = false;
   else {
    double test = Math.sqrt(j);
    int divisor = 3;
    while (prime && (divisor <= test)) {
     if (j % divisor == 0) {
      prime = false;
     } else divisor += 2;
    }
    if (prime) {
     values[val_cnt++] = j;
     System.out.println(j);
    }

   }
  }
 }
}