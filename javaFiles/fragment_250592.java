Query q1 = session.createQuery("from Table where value >= :v order by value asc";
q1.setXxx("v", myValue);         /* Xxx is Float or Long or Integer or... */
q1.setMaxResults(10);
List<Table> l1 = q1.list();
Query q2 = session.createQuery("from Table where value < :v order by value desc";
q2.setXxx("v", myValue);         /* Xxx is Float or Long or Integer or... */
q2.setMaxResults(10);
List<Table> l2 = q2.list();
/* now find the 10 nearest elements in Java code */
...
while (...) {
   ...
}