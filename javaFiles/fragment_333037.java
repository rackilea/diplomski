public static void addNullSafeOrCondition(final Criteria criteria, final Criterion... conditions) {
    if (conditions == null || conditions.length==0){
        return;
    }

    final List<Criterion> validCriterion = new ArrayList<Criterion>();

    for (final Criterion condition : conditions) {
        if (condition != null) {
            validCriterion.add(condition);
        }
    }
    if (validCriterion.isEmpty()) {
        return;
    }
    //Can't convert list to ... varargs
    criteria.add(Restrictions.or(validCriterion.toArray(new Criterion[ validCriterion.size() ]))); //public static Disjunction or(Criterion... predicates)--work's for one element also
  }