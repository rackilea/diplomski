class Moon{
    public final String name;
    public final Planet planet;
    public Moon(String name, Planet planet) {
        super();
        this.name = name;
        this.planet = planet;
    }
}

class Planet{
    public final String name;
    private List<Moon> moons = new ArrayList<>();
    public Planet(String name) {
        super();
        this.name = name;
    }
    public void addMoon(Moon moon){
        this.moons.add(moon);
    }
    public List<Moon> getMoons(){
        return this.moons;
    }
}