final private static class FilteringExpander implements PathExpander {
    private final Direction direction;

    private FilteringExpander(final Direction direction) {
        this.direction = direction;
    }

    public FilteringExpander() {
        this.direction = Direction.OUTGOING;
    }

    @Override
    public Iterable<Relationship> expand(Path neoPath, BranchState state) {
        if (!neoPath.endNode().getProperty("name").equals("London")) {
            return neoPath.endNode().getRelationships(RelationshipTypes.RELATED, direction);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public PathExpander reverse() {
        return new FilteringExpander(direction.reverse());
    }
}