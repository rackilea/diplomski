@Test
public void reciprocal() {
    Rational rat = new Rational(7, 5);
    String res = rat.reciprocal();
    assertEquals(5 + "/" + 7, res);
}