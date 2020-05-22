public interface SmartAdder extends Adder {
   int add(double a, double b);

   default int add(int a, int b) {
     return add((double)a, (double)b); // this calls the double method instead
  }
}