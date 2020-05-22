public final class MyEvaluator implements Evaluator {

    private int peopleCount;
    private int maxPeople;

    public MyEvaluator(int max) {
        maxPeople = max;
        peopleCount = 0;
    }

    public Evaluation evaluate(Path p) {

        //prune if we have found the required number already
        if(peopleCount >= maxPeople) return Evaluation.EXCLUDE_AND_PRUNE;

        //grab the node of interest
        Node n = p.endNode();

        //include if it is a person
        if(n.hasProperty("type") && (n.getProperty("type").equals(NodeTypes.PERSON.name()))) {
            peopleCount++;
            return Evaluation.INCLUDE_AND_CONTINUE;
        }

        // otherwise just carry on as normal
        return Evaluation.EXCLUDE_AND_CONTINUE;
    }
}