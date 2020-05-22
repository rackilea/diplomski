void assertGetChargesFails(int a, int b) {
  try {
    ac.getCharges(a, b);
    fail();
  } catch (IllegalArgumentException expected) {
  }
}