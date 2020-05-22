TestEinheit[i].create(new MyUnitContent(i) {
    public void form() {
        Unit entry = TestEinheit[this.i];
        rect(entry.getX(), entry.getY(), entry.getBreite(), entry.getLaenge());
    }
});