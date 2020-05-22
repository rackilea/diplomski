public class Harrison7b{
    public static void main(String[] args) {
        int B = 17;
        int[] arrayA = { 2, 4, 8, 19, 32, 17, 17, 18, 25, 17 };
        for (int i = 0; i < arrayA.length; i++)
            if (arrayA[i] != B) {
                System.out.print(arrayA[i]);
                System.out.print(i<arrayA.length-1? " ":"");
            }
    }
}