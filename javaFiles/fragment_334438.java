interface InterplanetaryTravelling<T> {
    String getCurrentPlanet();

    String whereWasI();
}

abstract class InterplanetaryTravellingDecorator<S> implements InterplanetaryTravelling<S> {

    private final InterplanetaryTravelling<? extends S> decoratedTraveller;

    InterplanetaryTravellingDecorator(InterplanetaryTravelling<? extends S> traveller) {
        this.decoratedTraveller = traveller;
    }

    @Override
    public String whereWasI() {
        String previousTravels = decoratedTraveller.whereWasI();

        return previousTravels.isEmpty() ? this.getCurrentPlanet()
                : previousTravels + ", " + this.getCurrentPlanet();
    }
}

class ToEarth<S> extends InterplanetaryTravellingDecorator<S> {

    ToEarth(InterplanetaryTravelling<? extends S> person) {
        super(person);
    }

    @Override
    public String getCurrentPlanet() {
        return "Earth";
    }

}

class ToMars<S> extends InterplanetaryTravellingDecorator<S> {

    ToMars(InterplanetaryTravelling<? extends S> person) {
        super(person);
    }

    @Override
    public String getCurrentPlanet() {
        return "Mars";
    }

}

class Person implements InterplanetaryTravelling<Person> {

    @Override
    public String getCurrentPlanet() {
        return "";
    }

    @Override
    public String whereWasI() {
        return "";
    }

}

abstract class Dog implements InterplanetaryTravelling<Dog> {

    @Override
    public String getCurrentPlanet() {
        return "";
    }

    @Override
    public String whereWasI() {
        return "";
    }

}

class Shepherd extends Dog { }