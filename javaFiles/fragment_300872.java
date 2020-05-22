public class Main {

    public static void main(String args[]) throws InterruptedException {

        ThreadGroup internalTG = new ThreadGroup("internal");
        Thread otherProcess = new Thread(internalTG, "Internal Program") {
            public void run() {
                OtherProgram.main(new String[0]);
            }
        };

        System.out.println("Starting internal program...");
        otherProcess.start();

        Thread.sleep(1000);
        System.out.println("Killing internal program...");

        internalTG.stop();
    }
}