public class Test{
    public static void main(String... args) throws Exception{
        Ball b = new Ball(() -> System.out.println("You hit it!"));
        Ball ba = new Ball((boolean miss) -> System.out.println(miss));

        b.hit();
        b.hit(false);
        ba.hit();
        ba.hit(false);
    }

    static public class Ball{
        final Hit a;
        final HitBoolean b;

        public Ball(Hit a){
            this.a = a;
            b = (miss) -> System.out.println("default " + miss);
        }

        public Ball(HitBoolean b){
            this.b = b;
            a = () -> System.out.println("default hit");
        }

        public void hit(){
            a.hit();
        }

        public void hit(boolean miss){
            b.hit(miss);
        }
    }

    public interface Hit{
        void hit();
    }

    public interface HitBoolean{
        void hit(boolean miss);
    }
}