import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number {
    static boolean primes;

    public static boolean number() {
        try {     
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < 2; i++) {

                BufferedReader br = new BufferedReader(new InputStreamReader(
                            System.in));
                String num1 = br.readLine();
                String num2 = br.readLine();

                int number1 = Integer.parseInt(num1);
                int number2 = Integer.parseInt(num2);

                for (int j = number1; j < number2; j++) {
                    if ( (j % 2) == 0 ) {
                        continue;
                    }
                    int x=0;
                    for (int k = 3; (k*k) <= j; k+=2) {
                        if(j % k == 0) {
                            x=1;
                            break;
                        }
                    }
                    if(x==1) continue;
                    buffer.append(j + " ");
                }
                System.out.println("All the primes b/n number " 
                       + number1  + " and number" + number2 + "  are :" 
                       + buffer.toString() );        
            }
        } catch (IOException e) {
              e.printStackTrace();
              }
        return primes;
    }

    public static void main(String[] args) {

        System.out.println("Enter two integer numbers to see what "
                           + "is the multitude b/w them: ");
        Number.number();
        }
    }