public enum Planet { 
    MERCURY, VENUS, EARTH, MARS, JUPITER, SATURN, URANUS, NEPTUNE; 

    private static Planet currentPlanet = MERCURY;

    public static Planet getCurrentPlanet()
    {
        return currentPlanet;
    }

    public static boolean setToNext() {
        boolean retVal = this.ordinal() < Planet.values().length - 1;
        currentPlanet = this.ordinal() < Planet.values().length - 1
                ? Planet.values()[this.ordinal() + 1]
                : Planet.values()[0];
        return retVal; //returns false when it was the last element of the enum
    }
}


public void doSomething()
{
    Planet planet;
    do
    {
        planet = Planet.getCurrentPlanet();
        //do things with planet, like write out their names
        System.out.println(planet.name());
    }
    while(Planet.setToNext());
}