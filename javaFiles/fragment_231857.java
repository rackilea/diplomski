int times = 3;

CountDownLatch completion = new CountDownLatch(2);

producer p = new producer(completion);
food me = new food(completion);
me.eat(times, p);


try {
    completion.await();
} catch (InterruptedException e) {
    e.printStackTrace();
}

System.out.println("Done");