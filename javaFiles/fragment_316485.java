public int whatever() {
  ... for ( ... {
    return x;
  }

  throw new RuntimeException("will never be reached");