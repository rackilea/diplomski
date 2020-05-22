public static double roundMyData(double Rval, int numberOfDigitsAfterDecimal) {
                  double p = (float)Math.pow(10,numberOfDigitsAfterDecimal);
              Rval = Rval * p;
              double tmp = Math.floor(Rval);
              System.out.println("~~~~~~tmp~~~~~"+tmp);
              return (double)tmp/p;
              }