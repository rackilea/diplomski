class Bag {

    private int sweets, in, out;
    private final int start,min, max;

    public Bag(int min, int max, int start) {

            this.min = min;
            this.max = max;
            this.start = start;
            sweets = start;
            in = start;
    }



    public synchronized void addSweet() {

        while(sweets==max) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        sweets++;
        in++;
        notifyAll();
    }

    public synchronized void removeSweet() {

        while(sweets==min) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        sweets--;
        out++;
        notifyAll();


    }

    public synchronized String delta() {
        return("Delta = " + (in-out-sweets) + " Sweets = " + sweets);
    }


}


class Child extends Thread { //consumer

    private Bag bag;
    public Child(Bag bag) {
        this.bag = bag;
    }

    public void run() {

        while(true) {
            bag.removeSweet();
        }
    }
}

class Parent extends Thread { //producer

    private Bag bag;

    public Parent(Bag bag) {
        this.bag = bag;
    }

    public void run() {

        while(true) {
            bag.addSweet();
        }
    }
}

public class Sweets {

    static int startValue, min, max = 0;

    public static void main(String[] args) throws InterruptedException {

        if(args.length<2) {
            System.err.println("Usage: java Sweets.java min max start");
            System.exit(1);
        }



        try {
            startValue = Integer.parseInt(args[2]);
            min = Integer.parseInt(args[0]);
            max = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Args must be integers.");
            System.exit(1);
        }


        Bag bag = new Bag(min, max, startValue);
        Child cthread = new Child(bag);
        Parent pthread = new Parent(bag);

        pthread.start(); //changed order here
        cthread.start();


        while(true) {

            Thread.sleep(2000);
            System.out.println(bag.delta());
        }
    }
}