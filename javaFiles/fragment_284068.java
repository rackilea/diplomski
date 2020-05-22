static int counter;

public void start() {
  counter = 0;
  recurse();
}

public void recurse() {
  counter += 1;
  if (whatever) { recurse(); }
}