public class ExtraCredit_Bazar {

    public static void main ( String arg[] ){

       for (int i=1; i<10; i += 2){
            for (int k=0; k < (4 - i / 2); k++){
                 System.out.print(" ");
            }
            int number = 1;
            for (int j=0; j < (i/2); j++){
                System.out.print(number);
                number *= 2;
            }
            for (int j= (i/2); j < i; j++){
                System.out.print(number);
                number /= 2;
            }
            System.out.println("");
        }
    }
}