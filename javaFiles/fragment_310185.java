s.append("select id \\:\\:numeric " + //that's a hack
      "from search_department " +
      "order by id");
Query q = getEntityManager().createNativeQuery(s);
List<Long> resList = new ArrayList<>();
List<BigDecimal> biglist = q.getResultList();
for (BigDecimal id : biglist) {
    System.out.print(id + ",");
    resList.add(id.longValue());
}