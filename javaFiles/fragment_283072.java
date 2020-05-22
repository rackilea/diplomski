interface CommandInterface {
    void execute();
}

class Controller implements CommandInterface {

    private static final int NUM_OF_STEPS = 10;

    private final Legs[] legs = {
        new Legs("left feet"),
        new Legs("right feet")
    };

    @Override
    public void execute() {
        Executors.newSingleThreadExecutor().execute(() -> {
            System.out.println("Init head");

            for (Legs leg : legs) {
                leg.start();
            }

            for (int i = 0; i < NUM_OF_STEPS; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);

                    int currentLegIndex = i % legs.length;
                    synchronized (legs[currentLegIndex]) {
                        System.out.println("head sends make " + (i + 1) + " step");
                        legs[currentLegIndex].notify();
                        legs[currentLegIndex].wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException("Interrupted!", e);
                }
            }
        });

    }

    class Legs extends Thread {
        private final String whichLeg;

        Legs(String whichLeg) {
            this.whichLeg = whichLeg;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    synchronized (this) {
                        this.wait();
                        step();
                        this.notify();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException("Interrupted!", e);
                }
            }
        }

        private void step() {
            System.out.println(whichLeg);
        }
    }
}

class ClientInterface {
    public static void main(String [] args) {
        new Controller().execute();
    }
}