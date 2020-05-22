void merge(Raum r, Fakultaet f, Standort s) {
 r.setFakultaet(f);
 r.setStandort(s);
 f.getRaums().add(r);
 s.getRaums().add(r);
 em.merge(r);
}