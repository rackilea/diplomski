@Test
public void testIt2() {
    if (assertionsEnabled) {
      assert new DoublerImpl().testIt(1) == 2;
    }
}