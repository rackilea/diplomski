package PrimeNum;

    public class primeNum {
    public static void main(String args[]){
        int flag = 0;
        System.out.println();

        for(int i = 2; i <= 100; i++){
            flag = 0;//Initialize flag to 0 here

            for(int j = 2; j <= 10; j++){
                if(i % j != 0) { 
                    flag++;
                }
            }

            if(flag == 9 || flag == 8){
                System.out.print(i + " ");
                flag = 0;
            }
        }
    }
}