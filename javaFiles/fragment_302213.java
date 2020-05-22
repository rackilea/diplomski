import java.util.Scanner;

public class HelloWorld{
    public static void main(String[] args) throws Exception {
        String[] firstName = new String[5];
        String[] lastName = new String[5];
        int score[] = new int[5];
        java.io.File file = new java.io.File("D:\\test.txt");
        Scanner input = new Scanner(file);

        int c = 0;
        while (input.hasNext()) {
            firstName[c] = input.next();
            lastName[c] = input.next();
            score[c] = input.nextInt();
            c++;
        }
        input.close();

        MichaelBubbleSort(score,firstName,lastName);
        for (int x = 4; x >= 0; x--) {
            System.out.print(firstName[x].substring(0, 1)
                    + lastName[x].substring(0, 1) + " " + score[x]);
            System.out.println();
        }
    }

    public static void MichaelBubbleSort(int[] arr,String[] firstName, String[] lastName) {
        int temp;
        String tempFirstName,tempLastName;
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;

                    tempFirstName = firstName[j -1];
                    firstName[j - 1] = firstName[j];
                    firstName[j] = tempFirstName;

                    tempLastName = lastName[j -1];
                    lastName[j - 1] = lastName[j];
                    lastName[j] = tempLastName;
                }
            }
        }
    }
}