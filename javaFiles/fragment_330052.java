@Override
public int compareTo(final Beer b) {
    final var compareBeer1 = getBeerType().trim() + getName().trim();
    final var compareBeer2 = b.getBeerType().trim() + b.getName().trim();
    return compareBeer1.compareTo(compareBeer2);
}