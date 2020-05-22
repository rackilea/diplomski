package com.test;

public class TrafficLightWorkerOne implements Runnable {

    private int cars;
    private MyLock lock;

    public TrafficLightWorkerOne(MyLock lock, int cars) {
        this.lock = lock;
        this.cars = cars;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                while (!lock.condition()) {
                    for (int carsOne = 0; carsOne < cars; carsOne++) {

                        System.out.println(Thread.currentThread().getName()
                                + " car no : " + carsOne);
                        // Light One---------------------------->

                        // Light Two---------------------------->
                    }
                    lock.notifyAll();
                    lock.flipCondition();
                }
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}