Disjunction d = Restrictions.disjunction();
... // d is set up here
Criteria linkedEntitySubcriteria = null;
try {
    List<CriteriaImpl.Subcriteria> subcriteriaList =
            (ArrayList) FieldUtils.readField(criteria, "subcriteriaList", true);
    for (CriteriaImpl.Subcriteria subcriteria : subcriteriaList) {
        if (subcriteria.getPath().equals(linkedEntityVariable)) {
            linkedEntitySubcriteria = subcriteria;
            break;
        }
    }
}
catch (IllegalArgumentException | IllegalAccessException e) {
    System.out.println("Can't get subcriteria");
}
if (linkedEntitySubcriteria == null) {
    linkedEntitySubcriteria = criteria.createCriteria(linkedEntityVariable);
}
linkedEntitySubcriteria.add(d);