boolean okay = false;
try {
  // do some work which might throw an exception
  okay = true;
} finally {
  if (!okay) // do some clean up.
}