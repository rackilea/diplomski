float stepsize () {
    while (true) {
        monte_carlo = random(0,10);
        float probability = monte_carlo;
        float r2 = random(0,10);
        if (r2 < probability) {
            return monte_carlo;
        }
    }
}