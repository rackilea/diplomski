final int[] i = new int[1];
for (i[0] = 0; i[0] < TestEinheit.length; i[0]++) {
    TestEinheit[i].create(new UnitContent() {
        public void form() {
            Unit entry = TestEinheit[i[0]];
            rect(entry.getX(), entry.getY(), entry.getBreite(), entry.getLaenge());
        }
    });
}