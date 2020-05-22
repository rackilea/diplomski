static Iterable<String> strings(final int radix, final int digits) {
  return new Iterable<String>() {

    public Iterator<String> iterator() {
      return new Iterator<String>() {

        private final String pad;
        {
          final StringBuilder buf = new StringBuilder(digits);
          for (int n = digits; n >= 0; --n) {
            buf.append('0');
          }
          pad = buf.toString();
        }

        private final int hi = (int) Math.pow(radix, digits);
        private int cursor;

        public boolean hasNext() {
          return cursor < hi;
        }

        public String next() {
          final String rsl = Integer.toString(cursor++, radix);
          return pad.substring(0, digits - rsl.length()) + rsl;
        }

        public void remove() {
          throw new UnsupportedOperationException();
        }
      };
    }
  };
}