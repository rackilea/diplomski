class ZiggyTest2{


        public static void main(String[] args) {  
             double num = 190253.80846153846;
              double round = roundMyData(num,2);
              System.out.println("Rounded data: " + round);
              }

              public static double roundMyData(double Rval, int numberOfDigitsAfterDecimal) {
                  double p = (float)Math.pow(10,numberOfDigitsAfterDecimal);
              Rval = Rval * p;
              double tmp = Math.floor(Rval);
              System.out.println("~~~~~~tmp~~~~~"+tmp);
              return (double)tmp/p;
              }
            }