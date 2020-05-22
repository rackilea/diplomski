public DeathNotificationObject() {
    System.out.println("I'm born.");
    PhantomReference<DeathNotificationObject> ref = new PhantomReference<DeathNotificationObject>(this, refQueue);
    ref.enqueue();
}

public static void main(String[] args) throws InterruptedException {

    for (int i = 0 ; i < 5 ; i++) {
        DeathNotificationObject item = new DeathNotificationObject();

        System.out.println("working with item "+item);
        Thread.sleep(1000);
        System.out.println("stopped working with item "+item);
        // simulate release item
        item = null;
    }

    try {
        System.gc();    
        Thread.sleep(3000); 
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}