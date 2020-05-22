package test;

public class Main {

    public interface MotherI {
        // this is static!
        public class Embryo {
            public void ecluse() {
                // NOPE, static context, can't access instance context
                // bear(this);
            }
        }
        // implicitly public abstract
        void bear(Embryo e);
    }

    public abstract class MotherA {
        public class Embryo {
            public void ecluse() {
                // ok, within instance context
                bear(this);
            }
        }

        public abstract void bear(Embryo e);
    }

    // instance initializer of Main
    {
        // Idiom for initializing static nested class
        MotherI.Embryo e = new MotherI.Embryo();
        /*
         *  Idiom for initializing instance nested class
         *  Note I also need a new instance of `Main` here,
         *  since I'm in a static context.
         *  Also note anonymous Mother here.
         */
        MotherA.Embryo ee = new MotherA() {public void bear(Embryo e) {/*TODO*/}}
           .new Embryo();
    }

    public static void main(String[] args) throws Exception {
        // nothing to do here
    }
}