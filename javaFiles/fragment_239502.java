if (!restrictionList.isEmpty()) {
    crit.add(or(restrictionList));
}

private Disjunction or(List<Criterion> restrictions) {
    Disjunction result = Restrictions.disjunction();

    for(Criterion restriction : restrictions) {
        result.add(restriction);
    }

    return result;
}