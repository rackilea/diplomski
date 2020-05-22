class XYZ

@Override
public final Plan getPlan() {
    subjects.addAll(plan.getSubjects());
    ...
    return new Plan("1", subjects.size(), subjects);
}

@Override
public final Graph createGraph() {
    Plan fPlan = getPlan();
    ...
    //edit fPlan here.
    return graph;
}