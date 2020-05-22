public enum Planet { 
    MERCURY, VENUS, EARTH, MARS, JUPITER, SATURN, URANUS, NEPTUNE; 

    public Planet getNext() {
        return this.ordinal() < Planet.values().length - 1
            ? Planet.values()[this.ordinal() + 1]
            : null;
    }
}

private Planet planet;

public void someFunction()
{
    planet = Planet.MARS;
    planet = planet.getNext();
    if(planet != null)
    {
        doStuff();
    }
}