public class FractionTest() {
    private Fraction f;

    @Test
    public void testLegalConstruction() {
        f = new Fraction (4, 7);
        assertEquals ("wrong num", 4, f.getNum());
        assertEquals ("wrong den", 7, f.getDen());

    @Test
    public void testIlegalConstruction() {
        f = new Fraction (3, 0);
        assertEquals ("wrong num", 3, f.getNum());
        assertEquals ("wrong den", 1, f.getDen()); // Note the 1
}