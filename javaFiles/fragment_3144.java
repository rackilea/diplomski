drawTicks(20, 20, 20);

public static void drawTicks(double h, double tick, double pos) {

    System.out.println("tick: " + tick + " pos: " + pos);

    if (tick / 2 >= 2) {

        if (tick != h) {
            drawTicks(h, tick / 2, pos + tick / 2);
        }

        drawTicks(h, tick / 2, pos - tick / 2);
    }

}