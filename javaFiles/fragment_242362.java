public class CountingDays {

    private LocalDate date = LocalDate.now();

    public static void main(String[] args) {

        CountingDays countingDays = new CountingDays();

        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                countingDays.date = countingDays.date.plusDays(1);
                System.out.println(countingDays.date);
            }
        };

        Timer timer = new Timer();
        long delay = 0;
        long intervalPeriod = 10_000;

        timer.schedule(task, delay, intervalPeriod);
    }
}