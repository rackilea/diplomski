abstract class Individuo<T> implements Comparable<Individuo<T>> {}

class Child extends Individuo {
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}