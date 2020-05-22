public class Main {
    public static void main(String[] args){
        System.out.println("Insert 10 numbers in order from least to greatest");
        Scanner input = new Scanner(System.in);
        int[] array = new int[10];
        for(int i=0; i<array.length; i++){
            int x = input.nextInt();
            array[i] = x;
        }

        String response = Server.checkFalse(array);
        System.out.println(response);
    }
}