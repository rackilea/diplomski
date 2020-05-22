public class TimerDemo extends TimerTask {

    public void run() {
        System.out.printf("Time is now %s%n", LocalTime.now());
    }

    public static void main(String[] args) throws IOException {
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerDemo(),
                TimeUnit.SECONDS.toMillis(5),
                TimeUnit.SECONDS.toMillis(10));
        System.out.printf("Program started at %s%n", LocalTime.now());
        System.out.println("Press enter to exit");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // Wait for user to press enter
            reader.readLine();
        }
        System.out.println("Bye!");
    }
}