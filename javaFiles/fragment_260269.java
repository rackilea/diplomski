class Child extends Individuo<Child> {
    @Override
    public int compareTo(Object o) { // this shouldn't compile
        return 0;
    }
}