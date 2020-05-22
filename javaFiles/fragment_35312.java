select e.name, rn from Employee e join refNumber rn where rn in (:refNumbers)

query.setParameter("refNumbers", refNumbers);

for (Object[] row : (List<Object[]>) query.list()) {
   String name = (String) row[0];
   String rn = (String) row[1];
}