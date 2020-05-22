final Predicate<name> bobRushPredicate = new Predicate<name>() {
   public boolean apply(name n) {
      return "bob".equals(n.getMiddlename()) && "rush".equal(n.getSurname());
   }
}

final List<name> results = Iterables.filter(applicants, bobRushPredicate));