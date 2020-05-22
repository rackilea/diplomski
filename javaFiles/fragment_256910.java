import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.image.WritableRaster;


public class fraktal extends JFrame   {
 int[] dataArray;
 public fraktal (String args[]) {
  Calculator calc = new Calculator(dataArray);    
  calc.start();
  }




 public static void main(String args[]) {
 fraktal ob =  new fraktal(args);
 System.out.println(ob.dataArray);
 }

}

class Calculator extends Thread {
 int[] dataArray;

 public Calculator(int[] dataArray) {
   this.dataArray = dataArray;
 }
 public void run() {    
  System.out.println(Arrays.toString(dataArray));    
 } 
}