public class Planet {
    private final String name;
    private final Set<String> moons = new HashSet<String>();

    // notice I set the name in the Constructor instead of a setter
    public Planet(String name) {
        this.name = name;
    }

    public void addMoon(String name) { 
        moons.add(name);
    }

    @Override
    public boolean equals(Object obj) { ...same as yours... }

    @Override
    public int hashCode() { ...same as yours... }

    public String getName() { return name; }

    public Set<String> getMoons() { return moons; }
}


// ... elsewhere ...

final Map<String,Planet> solarSystem = new HashMap<>();

public void addMoons(final String planet, final String... moons)
{
    Planet p = solarSystem.get(planet);
    if (p == null) {
        p = new Planet(planet);
        // add the Planet mapped by its name
        solarSystem.put(p.getName(), p);
    }
    for (final String moon : moons) {
        p.addMoon(moon);
    }
}