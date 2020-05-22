public class Lamborgini extends Thread {

    public void run() {
        int distance = 1000;
        int steps = 0;
        int velocity = 45;
        int acelerationTime = 800;
        while (steps < distance) {
            System.out.println("Lamborgini running");
            steps += velocity;
            try {
                Thread.sleep(acelerationTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Lamborgini finished the race");
    }
}

public class Ferrari implements Runnable {
    @Override
    public void run() {
        int distance = 1000;
        int steps = 0;
        int velocity = 130;
        int acelerationTime = 950;
        while (steps < distance) {
            System.out.println("Ferrari running");
            steps += velocity;
            try {
                Thread.sleep(acelerationTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Ferrari finished the race");
    }
}

public static class RaceMain {
    public static void main(String[] args) {
        Lamborgini lamborgini = new Lamborgini();
        lamborgini.start();

        Thread ferrari = new Thread(new Ferrari());
        ferrari.start();
    }
}