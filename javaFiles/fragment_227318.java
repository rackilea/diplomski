public String createPlan(AbstractPlan plan) {
    ...
    if (plan instanceof SchoolPlan) {
        return doSomethingWith(((SchoolPlan)plan).schoolType, ...)
    } else if (plan instanceof HighSchoolPlan) {
        return doSomethingElseWith(((HighSchoolPlan)plan).schedule, ...)
    ...
}