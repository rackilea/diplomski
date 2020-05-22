class TestThread extends Thread {
    private void recurse(int depth) {
        int a, b, c, d, e, f, g;
        if (depth < 100)
            recurse(depth + 1);
        for (;;) try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {}
    }

    @Override public void run() {
        recurse(0);
    }

    public static void main(String[] _) {
        for (int i = 0; i < 500; ++i)
            new TestThread().start();
    }
}