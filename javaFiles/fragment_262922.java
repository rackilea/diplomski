for (EntityManagerFactory emf : factories) {
  try {
    EntityType<?> entity = emf.getMetamodel().entity(classToCheck);
    // bingo
  } catch (Exception e) {
    // wrong persistence unit
  }
}