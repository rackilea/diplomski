//field
private Animal[] padres;
//constructor
public Animal(final Animal[] padres) {
    if (padres != null) {
        if (padres.length > 2) {
            throw new IllegalStateException("Too many parents");
        }
    }
    this.padres = padres;
}