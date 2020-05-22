Criteria stateCriteria = session.createCriteria(State.class);
Criteria countryCriteria = stateCriteria.createCriteria("country");
stateCriteria.addOrder(Order.desc("stateName"));
stateCriteria.setFirstResult(pagesize * pagenum);
stateCriteria.setMaxResults(pagesize);
stateCriteria.setProjection(Projections.projectionList()
            .add(Projections.property("stateName").as("stateName"))
            .add(Projections.property("country.name").as("countryName")));
List<StateDto> results = stateCriteria.list();