ArrayList<Measure> dataFiltered = allData.filter(new Predicate<Measure>() {
    @Override
    public boolean test(Measure m) {
        return (m.getTemperature() == 20 &&
                m.getHumidity() < 80);
    }
});