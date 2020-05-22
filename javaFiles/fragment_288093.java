ivList.get(0).setImageResource(R.drawable.drawable1); // this is doing in main thread
synchronized (this) {
    try {
        wait(500); // this blocks the main thread
    } catch (InterruptedException e) {
    }
}
ivList.get(1).setImageResource(R.drawable.drawable2); // this is also doing in main thread