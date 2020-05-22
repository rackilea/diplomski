public class NewClass {

        public static void main(String[] args) {
             int greatestExponent = 9;
             double x = 0.5;
             System.out.println(calculate(x,greatestExponent));
        }
        public static double getCoefficient(int n){
            double coff = 1;
            for(int i=1; i<n; i++){
                if(i%2==0){
                    coff = coff/i;       //if even put it in the denominator
                }
                else{
                    coff = coff*i;       // else numerator 
                }
            }
            return coff/n;          // at the end divide with the exponent (ex. x^9 /9)
        }
        public static double calculate(double x, int expo){
            double result = 1;
            for (int i = 1; i<= expo; i+=2){
                result +=  (getCoefficient(i)*Math.pow(x, i)); //for each odd exponent calculate the cofficient and x^i
            }
            return result;
        }
    }