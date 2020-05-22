try {
    for (int = 40; i > 0; --i) {
        updateGUI(i, label);
        Thread.sleep(1000);
    }
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();  // <-- THIS LINE IS IMPORTANT
}