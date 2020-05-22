class Animal {

    public String name;
    public int numlegs;
    public double weight;

    // ...

    @Override
    public String toString() {
        return String.format("Animal, name: %s, legs: %d, weight: %d", name, numLegs, weight);
    }

}