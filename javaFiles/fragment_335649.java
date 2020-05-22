public class Main {

    public static void main(String[] args) {

        String [] pngs = {"18.png","43.png", "27.png", "62.png", "71.png","34.png", "55.png", "86.png"};

        //this will sort by cheapest first
        java.util.Arrays.sort(pngs);
        printArray(pngs);

        //to sort by lowest rank first, swap digits, sort, re-swap digits
        swapFirstTwoDigits(pngs);
        java.util.Arrays.sort(pngs);
        swapFirstTwoDigits(pngs);
        printArray(pngs);


        //to sort by highest rank first, swap digits, sort, re-swap digits
        swapFirstTwoDigits(pngs);
        java.util.Arrays.sort(pngs,java.util.Collections.reverseOrder());
        swapFirstTwoDigits(pngs);
        printArray(pngs);

    }

    static void swapFirstTwoDigits(String[] array){
        for (int i = 0; i < array.length; i++) {
            String s = array[i];
            array[i] = ""+s.charAt(1)+s.charAt(0)+s.substring(2);
        }

    }


    static void printArray(String [] array){

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("-------------------");

    }
}