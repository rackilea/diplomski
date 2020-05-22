import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashSet;
import java.util.Set;

public class DeathNotificationObject {
    private static ReferenceQueue<DeathNotificationObject> refQueue = new ReferenceQueue<DeathNotificationObject>();
    private static Set<Reference<DeathNotificationObject>> refs = new HashSet<>();

    static {
        Thread deathThread = new Thread("Death notification") {
            @Override
            public void run() {
                try {
                    while (true) {
                        Reference<? extends DeathNotificationObject> ref = refQueue.remove();
                        refs.remove(ref);
                        System.out.println("I'm dying!");
                    }
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }
        };
        deathThread.setDaemon(true);
        deathThread.start();
    }

    public DeathNotificationObject() {
        System.out.println("I'm born.");
        PhantomReference<DeathNotificationObject> ref = new PhantomReference<DeathNotificationObject>(this, refQueue);
        refs.add(ref);
    }

    public static void main(String[] args) {
        for (int i = 0 ; i < 10 ; i++) {
            new DeathNotificationObject();                  
        }
        try {
            System.gc();    
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}