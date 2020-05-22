protected List<WorkerBean> query(String condition) {

    String queryString = "FROM Worker";
    System.out.println("adding to query");
    if (condition != null) {
        queryString += " " + condition;
        System.out.println(condition);
    }
    System.out.println("added to query");

    TypedQuery<Radnik> query = em().createQuery(queryString, Radnik.class);
    System.out.println("created query");

    System.out.println("starting query");
    List < Radnik > c = query.getResultList();

    System.out.println(c.size());

    List < WorkerBean > result = new ArrayList < WorkerBean > ();
    for (Radnik obj: c) {
        result.add(EntityToBean(obj));
    }

    return result;
}