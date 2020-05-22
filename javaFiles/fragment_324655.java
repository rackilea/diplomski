Query query = session.createQuery(hql);
List<TestProject> results = query.list();

for (TestProject row : results) {
    //what to do here
    // do whatever you want
}