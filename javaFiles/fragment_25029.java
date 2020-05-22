@Transactional
public void deleteFamily(Mother mother) {
  for (Child c: mother.getChildren()) {
    em.remove(c);
  }
  em.remove(mother);
}