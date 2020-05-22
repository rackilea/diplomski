boolean assertEnabled = false;

try {
   assert false;
} catch (AssertionError e) {
   assertEnabled = true;
}