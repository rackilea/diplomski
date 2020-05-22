CountDownLatch countDown = new CountDownLatch(1);

new Thread(() -> {
    countDown.await();
    A.sell(askbid_box[0][0], newqty);
}).start();
new Thread(() -> {
    countDown.await();
    B.buy(askbid_box[1][2], newqty);
}).start();

countDown.countDown();