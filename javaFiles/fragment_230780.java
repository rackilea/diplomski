@GET
@Path("Tokens")
@Produces("application/xml")
public JAXBElement<GetToken> getokenByName(@QueryParam("name") final String names) {
    if (names != null) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        Disjunction disjunction = Restrictions.disjunction(); 
        for (String name: names.split(",")) {
            disjunction = disjunction.add(Restrictions.eq("name", name));
        } 
        crit.add(disjunction);
    }
    ...
}