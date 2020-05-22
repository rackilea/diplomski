public Map<Integer, List<Integer>> findDisqualifiedDriversInRaces(List<Integer> raceIds) {
    ProjectionList projection = Projections.projectionList()
            .add(Projections.property("race.id").as("race.id"))
            .add(Projections.property("startingNr").as("startingNr"));

    return (Map<Integer, List<Integer>>) getSession()
            .createCriteria(RaceDriver.class)
            .setProjection(projection)
            .add(Restrictions.in("race.id", raceIds))
            .add(Restrictions.eq("disqualified", true))
            .setResultTransformer(new MapOfListsResultTransformer<Integer, Integer>())
            .uniqueResult();
}