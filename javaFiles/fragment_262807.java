public void someAction() {
    for(int i = 0; i < 5; i++) {
        scheduleTask(i);
    }
}

public void scheduleTask(int i) {
    Runnable test = () -> {
        System.out.println("Task " + i + ": " + Thread.currentThread());
    };
    time.addListener((obs, oldV, newV) -> {
        execute.execute(test);
    });
}