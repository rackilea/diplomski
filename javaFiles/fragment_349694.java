public class ThreadTree {

private static final ExecutorService executor = Executors.newCachedThreadPool();

public static void main(String[] args) {
    List<Integer> level1Nodes = new ArrayList<Integer>();
    level1Nodes.add(2);
    level1Nodes.add(5);
    level1Nodes.add(8);
    // start threads
    for (Integer num : level1Nodes) {
        executor.submit(new Level1(num));
    }
}

private static class Notification {
    private final Object result;
    private final Exception rootException;

    public Notification(Object result, Exception rootException) {
        this.result = result;
        this.rootException = rootException;
    }

    public Object getResult() {
        return result;
    }

    public Exception getRootException() {
        return rootException;
    }
}

private static abstract class NotificationHandler {
    private final AtomicInteger expectedNotifications;
    private final List<Notification> notifications;

    public NotificationHandler(int expectedNotifications) {
        this.expectedNotifications = new AtomicInteger(expectedNotifications);
        this.notifications = new ArrayList<Notification>();
    }

    public void handleNotification(Notification notification) {
        notifications.add(notification);
        if (expectedNotifications.decrementAndGet() == 0) {
            postRun(notifications);
        }
    }

    public void postRun(List<Notification> notifications) {
        for (Notification notification : notifications) {
            System.out.println("Status: " + (notification.getRootException() == null ? "Failed" : "Success") + ", Result: " + (notification.getResult() != null ? notification.getResult() : "No result"));
        }
    }
}

private static class Level1 extends NotificationHandler implements Runnable {
    private final int num;

    public Level1(int num) {
        super(num);
        this.num = num;
    }

    public void run() {
        for (int i = 0; i < num; i++) {
            executor.submit(new Level2(2, this)); // 2 is just an assumed number of nodes at level 2
        }
    }
}

private static class Level2 extends NotificationHandler implements Runnable {
    private final int num;
    private final NotificationHandler parentNotificationHandler;

    public Level2(int num, NotificationHandler parentNotificationHandler) {
        super(num);
        this.num = num;
        this.parentNotificationHandler = parentNotificationHandler;
    }

    public void run() {
        for (int i = 0; i < num; i++) {
            executor.submit(new Level2(2, this)); // 2 is just an assumed number of nodes at level 3
        }
        // execute the task and then notify parent
        parentNotificationHandler.handleNotification(new Notification("done", null));
    }
}

private static class Level3 extends NotificationHandler implements Runnable {
    private final int num;
    private final NotificationHandler parentNotificationHandler;

    public Level3(int num, NotificationHandler parentNotificationHandler) {
        super(num);
        this.num = num;
        this.parentNotificationHandler = parentNotificationHandler;
    }

    public void run() {
        // execute the task and then notify parent
        parentNotificationHandler.handleNotification(new Notification("done", null));
    }
}
}