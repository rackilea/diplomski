public class Main {
    public static void main(String[] args) {
        int[] tab = { 1, 2, 3, 4 };
        System.out.println(numberEven(tab));
    }

    public static int numberEven(int[] tab) {
        int n = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] % 2 == 0) {
                n += tab[i];
            }
        }
        return n;
    }
}