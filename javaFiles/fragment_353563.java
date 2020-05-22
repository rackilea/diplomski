Comparator<Villain> villainComparator = Comparator.comparingInt(Villain::getGood)
    .thenComparingInt(Villain::getBad)
    .thenComparingInt(Villain::getUgly);

Villain result = villains.stream()
                         .max(villainComparator)
                         .orElse(null);