public synchronized void bow(Friend bower)
{
    System.out.format("%s %s: %s has bowed to me!%n", System.currentTimeMillis(), this.name, bower.getName());
    try {
        Thread.sleep(50);
    } catch (InterruptedException e) {
        // ignore
    }
    bower.bowBack(this);
}