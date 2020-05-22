void merge(Raum r, Fakultaet f, Standort s) {
 try {
  r.setFakultaet(f);
  r.setStandort(s);
  f.getRaums().add(r);
  s.getRaums().add(r);
  em.merge(r);
  r.setVersion(r.getVersion() + 1);
 }
 catch(RuntimeException re) {
  // logging
  throw re;
 }
}