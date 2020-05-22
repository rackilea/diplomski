Thread trx = new Thread(clTh);
Thread ttx = new Thread(csTh);

trx.start();
ttx.start();
while(trx.isAlive()) {
    Thread.currentThread().sleep(1000);
}

while(ttx.isAlive()) {
    ttx.interrupt();
    Thread.currentThread().sleep(1000);
}