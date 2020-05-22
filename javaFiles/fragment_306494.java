class XYZ

private Plan plan;

@Override
public final void instantiatePlan() {
    subjects.addAll(plan.getSubjects());
    ...
    plan = new Plan("1", subjects.size(), subjects);
}

@Override
public final Graph createGraph() {
    plan = instantiatePlan();
    ...
    return graph;
}