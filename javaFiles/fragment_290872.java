public boolean isABC(String line) {
  // fill stack
  Stack<Character> stack = new Stack<Character>();
  for (int i=0; i<line.length(); i++) {
      stack.push(line[i]);
  }

  // reverse operations while popping from stack
  char prev = 'A';
  while ( ! stack.isEmpty()) {
      char c = stack.pop();
      switch (c) {
          case 'A': if (prev != 'B') return false; break;
          case 'B': if (prev != 'C') return false; break;
          case 'C': if (prev != 'A') return false; break;
      }
      prev = c;
  }
  return prev == 'A';
}