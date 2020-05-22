public class RefTest {

    private static class Ref {
        /* Don't do this in real life, public fields are bad practice.
         * just done here for sake of example.
         * make a getter and setter at the very least.
         */
        public int someInt;  
    }

    private static class RefMod {
        private Ref r;
        public RefMod(Ref r) {
            this.r = r;
        }

        public void setRefInt(int newInt) {
            r.someInt = newInt;
        }
    }

    public static void main(String[] args) {
        Ref ref = new Ref();
        ref.someInt = 11;

        System.out.println(ref.someInt);

        RefMod refMod = new RefMod(ref);
        refMod.setRefInt(42);

        System.out.println(ref.someInt);

        final Ref fRef = new Ref();
        fRef.someInt = 300;

        System.out.println(fRef.someInt);

        refMod = new RefMod(fRef);
        refMod.setRefInt(500);

        System.out.println(fRef.someInt);
    }
}