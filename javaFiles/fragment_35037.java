while (true) {
    try {
        Thread.sleep(100);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        return;
    }
    synchronized (this) {
        System.out.print("Altura: ");
        altura = in.nextInt();
        System.out.print("Largura: ");
        largura = in.nextInt();
        notify();
    }
}