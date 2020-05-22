for (TableB b : bList) {
  TableJ j = new TableJ();
  em.persist(j)
  j.addTableB(b);
  tableA.addTableB(b);
}