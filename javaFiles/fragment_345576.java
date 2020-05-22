filter(new Predicate<Taxi>() {
    @Override
    public boolean test(Taxi t) {
        return t.isFree();
    }
})