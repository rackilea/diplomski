import java.util.HashSet;
import java.util.Set;

class Immortal {

    // making it public and non-fianl to modify from outside
    public static Set<Immortal> immortals = new HashSet<>();

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Running finalize for " + this);
        immortals.add(this); // Resurrect the object by creating a new reference
    }
}

public class ObjectResurrection {

    public static void callGC() {
        // call garbage collection
        System.gc();

        // wait for some time to give chance to run garbage collection thread
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Immortal immortal1 = new Immortal();
        Immortal immortal2 = new Immortal();

        // print objects when they are alive.
        System.out.println("immortal1 = " + immortal1);
        System.out.println("immortal2 = " + immortal2);

        // print immortal set
        System.out.println("immortal set = " + Immortal.immortals);

        // make all objects garbage collectable
        immortal1 = null;
        immortal2 = null;

        callGC();

        // now objects will be null
        System.out.println("immortal1 = " + immortal1);
        System.out.println("immortal2 = " + immortal2);

        // but stays in immortal set
        System.out.println("immortal set = " + Immortal.immortals);

        // remove all objects from immortal set, and make them again eligible for GC
        Immortal.immortals.clear();

        callGC();

        // again print the immortal set
        // this time set will be empty, and those 2 objects will be destroyed by Garbage
        // Collection,
        // but this time they will not call finalize, because it is already called
        // you can notice no output from finalize method in the output this time
        System.out.println("immortal set = " + Immortal.immortals);
    }

}