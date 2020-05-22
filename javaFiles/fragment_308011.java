enum Ability {
    FIREBALL("Fireball", 3, 5, new Effect[] {
        new Effect(Mechanic.DAMAGE, 10, 0),
        new Effect(Mechanic.BURN, 2, 3)
    });

    private final String name;
    private final int level;
    private final int cost;
    private final List<Effect> effects;
}