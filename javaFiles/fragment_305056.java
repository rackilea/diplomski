....
List<Object[]> results = crit.list();

for (Object[] result : results) {
    Integer maxPrice = (Integer)result[0];
    Integer minPrice = (Integer)result[1];
    Long count = (Long)result[2];
}