import com.utad.idcd.redes.PrimeNumber;
    public class TestPrime {
    public static void main(String[] args) {
        int arrayInt[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        for(int i=0; i<9; i++){

            System.out.print("El" + arrayInt[i] + "es: ");

            if(PrimeNumber.isPrime(arrayInt[i])==true){
               System.out.print("primo\n");
            }
            else {
                System.out.print("no primo\n");
            }
        }    
    } 
 }