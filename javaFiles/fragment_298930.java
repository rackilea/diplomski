/**
 *
 */
public static Specification<Pets> findByCriteria() {

    return new Specification<Pets>() {

        @Override
        public Predicate toPredicate(Root<Pets> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

            List<Predicate> predicates = new ArrayList<Predicate>();

            // solo attivita attive
            predicates.add(cb.equal(root.get("pet_name"), "Chelsea"));

            return cb.and(predicates.toArray(new Predicate[]{}));
        }
    };
}

/**
 * TODO MANAGE VARIOUS TYPES
 */
private String createParam(Parameter<?> p, Query<?> q) {

    Class<?> clz = p.getParameterType();
    if (clz == String.class) {
        return "'" + q.getParameterValue(p.getName()) + "'";
    }
    return "";
}


/**
 *
 */
public void getEnterprisesAdmin() {

    Specification<Pets> spec = this.findByCriteria();

    CriteriaBuilder builder = this.em.getCriteriaBuilder();
    CriteriaQuery<Pets> query = builder.createQuery(Pets.class);

    Root<Pets> root = query.from(Pets.class);

    Predicate predicate = spec.toPredicate(root, query, builder);
    query.where(predicate);

    TypedQuery<Pets> findAllBooks = em.createQuery(query);
    Query<Pets> q = findAllBooks.unwrap(Query.class);

    String strQuery = q.getQueryString();

    strQuery = Pattern.compile("(.*?)select \\w*").matcher(strQuery).replaceFirst("SELECT *");

    Set<Parameter<?>> pList = q.getParameters();
    Iterator<Parameter<?>> iter = pList.iterator();
    for (int i=0; i<pList.size(); i++) {
        Parameter<?> p = iter.next();
        strQuery = strQuery.replace(":" + p.getName(), this.createParam(p, q));
    }

    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mempoi?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(strQuery);

        resultSet.next();
        System.out.println("PET NAME: " + resultSet.getString("pet_name"));
    } catch (Exception e) {
        e.printStackTrace();
    }
}