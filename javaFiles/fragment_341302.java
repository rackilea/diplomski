//Example dynamic query
StringBuilder builder = new StringBuilder("select e from Employee e");
if (empName != null) {
    builder.append(" where e.name = ?");
}
getEntityManager().createQuery(builder.toString());