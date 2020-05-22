public void output() {
    if (weather == 1) {
        players = 0.25 * val1;
    }

    if (weather == 2) {
        players = 0.12 * val1;
    }

    if (weather == 3) {
        players = 0.03 * val1;
    }

    System.out.println(players + " will play golf today!");
}