@Override
public boolean equals(Object o) {
    return (o instanceof Flower && ((Flower)o).flower.equals(flower)) ||
                (o instanceof String && o.equals(flower));
}

@Override
public int hashCode() {
    return flower.hashCode();
}