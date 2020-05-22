TreeSet<Custom> ts = ...
TreeSet<Custom> tsWithExtra = new TreeSet(ts);

for (Custom c : ts) {
  // possibly add to tsWithExtra
}

// continue, using tsWithExtra