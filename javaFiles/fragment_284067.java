public void run(int opt) {
  run_helper(opt, 0);
}

private void run(int opt, int depth) {
  if (whatever) { run(opt, depth + 1); }
}