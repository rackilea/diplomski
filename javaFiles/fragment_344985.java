public List<Instance> getMatchingInstances(Map<String, String> attrValues) {
    Criteria crit = session.createCriteria(Instance.class, "i");
    for(Map.Entry<String, String> entry : attrValues) {
        String attrName = entry.getKey();
        String val = entry.getValue();

        // Create the subquery
        DetachedCriteria valueCrit = DetachedCriteria.forClass(Value.class, "v");

        // Join the Attribute object (left outer join)
        DetachedCriteria attrCrit = 
          valueCrit.createCriteria("attribute", CriteriaSpecification.LEFT_JOIN);

        // Put together the OR statement on the Attribute joined criterion.
        Criterion localAttr = Restrictions.eq("v.localAttributeName", attrName);
        Criterion globalAttr = Restrictions.eq("name", attrName);
        attrCrit.add(Restrictions.or(localAttr, globalAttr));

        // Simple column equality on the subquery criterion.
        valueCrit.add(Restrictions.eq("value", val));

        // Map the subquery back to the outer query.
        valueCrit.add(Restrictions.eqProperty("instance.id", "i.id"));

        // Add the missing projection.
        valueCrit.setProjection(Projections.property("id"));

        // Add this subquery to the outer query.
        crit.add(Subqueries.exists(valueCrit));
    }
    return crit.list();
}