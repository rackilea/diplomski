public static ImmutableVector copyOf(Vector v) {
  if (v instanceof ImmutableVector) {
    return (ImmutableVector)v;
  } else {
    return new ImmutableVector(v);
  }
}