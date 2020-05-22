foo(a, b, c) {
  if (a) {
    return foo2(b, c);
  }
  return 3;
}

foo2(b, c) {
  if (b && c) {
    return 1;
  }
  return 2;
}