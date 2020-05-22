public static void main(String[] args) {
    Timer timer = new Timer();

    for (int i = 0; i < 10; i++) {
        timer.schedule(new NamedTimerTask("task" + i) {
            @Override
            public void run() {
                System.out.println(name);
            }
        }, 1000);
    }
}

static abstract class NamedTimerTask extends TimerTask {

    final String name;

    NamedTimerTask(String name) {
        this.name = name;
    }
}