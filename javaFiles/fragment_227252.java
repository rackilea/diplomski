public void addB(B b) {
  bs.add(b);
  mapB(b);
}

public void removeB(B b) {
  bs.remove(b);
  bsMappedByCName.remove(b.getC().getName());
}