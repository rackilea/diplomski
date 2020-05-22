List<Class<? extends Weapon>> weapons = Arrays.asList(Dagger.class, Rifle.class);

public Weapon create(Class<Weapon> weaponType) {
    try {
        return weaponType.newInstance();
    } catch (InstantiationException | IllegalAccessException ex) {
        throw new RuntimeException("Not possible");
    }
}