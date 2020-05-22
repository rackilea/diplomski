void flock(ArrayList uninfected, ArrayList infected) {
  PVector sep = separate(uninfected);   // Separation
  PVector ali = align(uninfected);      // Alignment
  PVector coh = cohesion(uninfected);   // Cohesion
  PVector pan = panic(infected);        // Panic
  // Arbitrarily weight these forces
  sep.mult(4.0);
  ali.mult(1.0);
  coh.mult(2.0);
  pan.mult(-3.0);
  // Add the force vectors to acceleration
  acc.add(sep);
  acc.add(ali);
  acc.add(coh);
  acc.add(pan);
}