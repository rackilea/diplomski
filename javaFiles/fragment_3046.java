if (thread.getState() == Thread.State.NEW) {
    thread.start();
    // Ok, the thread is now beginning to work on it
} else if (thread.getState() != Thread.State.TERMINATED) {
    // Yay, the thread is working on it
} else {
    // Oops, what happened???
]