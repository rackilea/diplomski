private static final int NUM_HEALTH_BARS = 5;

private double health = 35;
private final double maxHealth = 80;

private final HealthBar[] healthBars = /* whatever */;

public void onHealthChange(final int newHealth)
{
    this.health = newHealth;
    updateHealthBars();
}

private void updateHealthBars()
{
    final double increment = maxHealth / NUM_HEALTH_BARS;

    for (int i = 1; i <= NUM_HEALTH_BARS; ++i)
    {
        double howFull = (health - ((i - 1) * increment)) / increment;
        howFull = Math.min(howFull, 1.0);
        howFull = Math.max(howFull, 0.0);

        // howFull is 0 to 1, so times by 100 if you need it as a percentage:

        healthBars[i].setFull(howFull * 100);
    }
}