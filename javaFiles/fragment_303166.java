public void addKitten(Kitten kitten) {
  if (kittens == null) {
    kittens = new HashSet<Kitten>();
  }
  kittens.add(kitten);
  kitten.setCat(this);
}