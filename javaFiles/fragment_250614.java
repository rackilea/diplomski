public class ToweringStrings2 {
    public static final int H = 10; //constant for the tower

    public static void main(String[] args) {
        drawTowers(H);
    }

    public static void drawTowers(int H) {
        int count = 1;
        for (int i = 1; i <= H; i++) {
            System.out.print(" ");
            for (int j = 1; j <= i; j++) {
                System.out.print(count++ + " ");
            }
            System.out.println();
        }
        for (int k = 1; k <= H + 2; k++) {
            System.out.print("@ ");
        }
        System.out.println();
    }
}