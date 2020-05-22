class GuavaServer {
    public static void main(String[] args) throws InterruptedException {
        GuavaServer gs = new GuavaServer();
        Set<ForceStoppableScheduledService> services = new HashSet<>();
        ForceStoppableScheduledService ts = gs.new ForceStoppableScheduledService();
        services.add(ts);
        ServiceManager manager = new ServiceManager(services);
        manager.addListener(new Listener() {
            public void stopped() {
                System.out.println("Stopped");
            }

            public void healthy() {
                System.out.println("Health");
            }

            public void failure(Service service) {
                System.out.println("Failure");
                System.exit(1);
            }
        }, MoreExecutors.directExecutor());

        manager.startAsync(); // start all the services asynchronously
        Thread.sleep(3000);
        manager.stopAsync();
        //maybe make a manager.StopNOW()?
        for (ForceStoppableScheduledService service : services) {
            service.triggerShutdown();
        }
    }

    public class ForceStoppableScheduledService extends AbstractScheduledService {

        Thread thread;

        @Override
        protected void runOneIteration() throws Exception {
            thread = Thread.currentThread();
            try {
                System.out.println("Working");
                Thread.sleep(10000);
            } catch (InterruptedException e) {// can your long process throw InterruptedException?
                System.out.println("Thread was interrupted, Failed to complete operation");
            } finally {
                thread = null;
            }
            System.out.println("Done");
        }

        @Override
        protected Scheduler scheduler() {
            return Scheduler.newFixedRateSchedule(0, 1, TimeUnit.SECONDS);
        }

        protected void triggerShutdown() {
            if (thread != null) thread.interrupt();
        }
    }
}