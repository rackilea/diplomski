static int BITS_IN_INTEGER = 4;
static int INTEGER_MASK = (1 << BITS_IN_INTEGER) - 1;

static int leftRotate(int x, int n) {
  return INTEGER_MASK & ((x << n) | (x >>> (BITS_IN_INTEGER - n)));
}