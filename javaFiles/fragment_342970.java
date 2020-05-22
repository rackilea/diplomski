package com.test;

public class TrafficLightWorkerTwo implements Runnable {

    private int cars;
    private MyLock lock;

    public TrafficLightWorkerTwo(MyLock lock, int cars) {
        this.lock = lock;
        this.cars = cars;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (lock) {
                try {
                    while (!lock.condition()) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                for (int carsOne = 0; carsOne < cars; carsOne++) {

                    System.out.println(Thread.currentThread().getName()
                            + " car no : " + carsOne);
                    // Light One---------------------------->

                    // Light Two---------------------------->
                }
                lock.flipCondition();;
                lock.notifyAll();
            }
        }

    }
}