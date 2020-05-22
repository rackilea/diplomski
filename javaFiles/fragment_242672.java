package com.thread.concurrency;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main mainObj = new Main();
        List<Integer> stack = new LinkedList<Integer>();
        Producer producer = mainObj.new Producer(stack);
        Consumer consumer = mainObj.new Consumer(stack);
        producer.start();
        consumer.start();
    }

    private class Producer extends Thread {
        public Producer(List<Integer> s) {
            mStack = s;
        }

        private List<Integer> mStack = null;
        private int mNumber = 0;

        @Override
        public void run() {
            // TODO generates number here
            while (true) {
                synchronized (mStack) {
                    while(!mStack.isEmpty())
                    {
                        try{
                            mStack.wait(); // this.wait();
                        } catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                mNumber++;
                System.out.println("Producer generates number:" + mNumber);
                mStack.add(mNumber);
                    mStack.notifyAll();// this.notifyAll();
                }
            }   
        }
    }

    private class Consumer extends Thread {
        public Consumer(List<Integer> s) {
            mStack = s;
        }

        private List<Integer> mStack = null;

        @Override
        public void run() {
            // TODO consume number here.
            while(true){
                synchronized (mStack) {
                    while(mStack.isEmpty())
                    {
                        try{
                            mStack.wait(); // this.wait();
                        } catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                int number = ((LinkedList<Integer>) mStack).removeLast();
                System.out.println("Consumer consumes number:" + number);
                    mStack.notifyAll();// this.notifyAll();
                }
            }}

    }
}