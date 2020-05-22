public static void main(String[] args) {
    while (true) callMethod();
}

private static long lastTime = System.currentTimeMillis();
public static void callMethod() {
    long now = System.currentTimeMillis();
    long last = lastTime;
    lastTime = now;

    double fps = 1000 / (double)(now - last);
    System.out.println(fps);
}