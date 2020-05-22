public boolean isABC(String line) {
  int total = line.length();
  int position = 0;
  char prev = 'C';
  while (position < total) {
      char c = line.get(position++);
      switch (c) {
          case 'A': if (prev != 'C') return false; break;
          case 'B': if (prev != 'A') return false; break;
          case 'C': if (prev != 'B') return false; break;
      }
      prev = c;
  }
  return prev == 'C';
}