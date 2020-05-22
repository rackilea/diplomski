public class Loop {
    public static void main(String[] args) {
        for(int i = 0; i < 50; i++){
            if((i%10 == 0) && i > 0)
                System.out.print("\n");
            System.out.print("[0]");
        }
    }
}