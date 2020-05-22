public class BothVegetable implements Vegetable {
    public void writeVeggieDataInfoFile() {
        Thread thread1 = new Thread(new AppleRunnable());
        Thread thread2 = new Thread(new MangoRunnable());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}

// and in your factory

    return new CompositeVegetable();