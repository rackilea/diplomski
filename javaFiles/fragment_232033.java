public synchronized void foo(Entity entity) {
    if (entity.getStatus() == Status.READY) {
        new Task(entity).start();
    } else {
        // ...
    }
}