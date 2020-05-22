static final ResourceManager manager = new ResourceManager();
public static void main(String[] args) {
    Resource r1 = manager.getResource();
    Resource r2 = manager.getResource();
    System.out.println("r1 = "+r1+", r2 = "+r2);
    r1 = null;
    forceGC();

    r1 = manager.getResource();
    System.out.println("r1 = "+r1);
    r1 = null;
    forceGC();

    r1 = manager.getResource();
    System.out.println("r1 = "+r1);

    manager.stopReusing(r1);

    r1 = null;
    forceGC();

    r1 = manager.getResource();
    System.out.println("r1 = "+r1);
}
private static void forceGC() {
    for(int i = 0; i<5; i++ ) try {
        System.gc();
        Thread.sleep(50);
    } catch(InterruptedException ex){}
}