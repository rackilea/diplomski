String sql = "SELECT field_1, field_2, field_3 FROM table";
Query q = em.createNativeQuery(sql);
List<Object[]> results = q.getResultList();

for (Object[] r : results) {
    System.out.println("(field_1, field_2, field_3) = (" + r[0] + ", " + r[1] + ", " + r[2] + ")");
}