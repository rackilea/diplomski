public class ArraySummation {

    public static void main(String[] args) {
        String input;
        int number, j = 0;
        int[] arr, arr2;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("How many numbers do you want to enter? ");
        number = keyboard.nextInt();

        arr = new int[number];
        for (int index = 0; index < arr.length; index++) {
            System.out.print("Enter number: ");
            arr[index] = keyboard.nextInt();
        }

        arr2 = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr2[j++] = arr[i];
        }
        //I believe you have reversed arr into arr2 correctly
        //this should print them out the way you wanted
        for(int i=0;i<(arr.length/2);i++){
            System.out.println("Adding " + arr[i] + " and " + arr2[i] + ": ");
            System.out.println(arr[i] + arr2[i]);
        }
    }
}