import java.io.*;

public class Ejercicio {
    private static void divisor(int num, int presuntoDivisor){
        if(num % presuntoDivisor == 0) 
            System.out.println("un divisor es "+ presuntoDivisor);

        if(presuntoDivisor == num) return;

        divisor(num, ++presuntoDivisor);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int num, presunto=1;

        BufferedReader linea = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("introduce un numero: ");

        num = Integer.parseInt(linea.readLine());
        divisor(num, presunto);
    }
}