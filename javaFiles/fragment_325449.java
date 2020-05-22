public class HelloJava {    
    static int[] inpoot() { // this method has to return int[]
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[10];

        System.out.println("Please enter 10 numbers ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextInt();
        }
        return numbers; // return array here
    }

    static void outpoot(int[] numbers) {
        for(int i = 0; i < numbers.length; i++) { 
            System.out.println(numbers[i]); 
        }
    }

     public static void main(String[] args) {
        int[] numbers = inpoot(); // get the returned array
        outpoot(numbers); // and pass it to outpoot
    }
}