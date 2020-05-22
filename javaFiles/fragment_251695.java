int frameCap = 120;
    int fps = 0;

    double delta = 0D;
    long last = System.nanoTime();
    long timer = 0L;

    while (true) {
        long now = System.nanoTime();
        long since = now - last;

        delta += since / (1000000000D / frameCap);
        timer += since;
        last = now;

        if (delta >= 1D) {
            tick();
            render();

            fps++;

            delta = 0D;
        }

        if (timer >= 1000000000L) {
            System.out.println("fps: " + fps);

            fps = 0;

            timer = 0L;
        }
    }