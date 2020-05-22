Bitset bb = new BitSet(2 * p.length());
for (int i = 0; i < p.length(); ++i) {
  switch (p.charAt(i)) {
    case 'A':
      bb.set(2*i + 0, false);
      bb.set(2*i + 1, true);
      break;
    case 'G':
      bb.set(2*i + 0, false);
      bb.set(2*i + 1, false);
      break;
    // etc.
  }
}