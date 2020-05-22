class Funny implements Comparable<Long> { ... }
class Funnier implements Identifiable {
    public Comparable<Long> getIdentifier() {
        return new Funny();
    }
}

Identifiable<Funny> funnier;
funnier.getIdentifier().compareTo(funnier.getIdentifier());
// You just tried to pass a Funny to compareTo(Long)