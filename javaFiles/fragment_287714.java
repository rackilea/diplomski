Object o = getTheValue();
int result = 0; // we have to initialize it here!
if (o instanceof Integer) {
  result = (Integer) o;
} else {
  throw new WTFThisShouldHaveBeenIntegerException();
}