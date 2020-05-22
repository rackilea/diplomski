public class Loop {
    public static void main(String[] args) {
        for(int i = 1; i < 51; i++){
            System.out.print("[0]");

            if((i%10 == 0) && i > 0)
                System.out.print("\n");
        }
    }
}