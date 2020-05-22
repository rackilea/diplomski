public class LazyElvis {
    enum Elvis {
        THE_ONE;
        Elvis() {
            System.out.println("I'M STILL ALIVE!!!");
        }       
    }
    public static void main(String[] args) {
        System.out.println("La-dee-daaa...");
        System.out.println(Elvis.THE_ONE);
    }
}