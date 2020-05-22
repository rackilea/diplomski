public char pop() {
     if (top >= 0) {
        return sa[top--];
     }
     throw new EmptyStackException();
  }