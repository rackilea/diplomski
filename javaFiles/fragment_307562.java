for (Tuteur tuteur in commune.tuteurs) {
    tuteur.getCommunes().remove(commune);
    entityManager.persist(tuteur);
}

commune.getTuteurs().clear();
entityManager.persist(commune);
entityManager.remove(commune);