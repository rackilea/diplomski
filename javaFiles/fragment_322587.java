PathExpanderBuilder pathExpanderBuilder = PathExpanderBuilder.empty();

pathExpanderBuilder.add(RelationshipType.withName("worksat"), Direction.OUTGOING);
pathExpanderBuilder.add(RelationshipType.withName("competitorof"), Direction.BOTH);
pathExpanderBuilder.add(RelationshipType.withName("worksat"), Direction.INCOMING);

PathExpander<Object> pathExpander pathExpander = pathExpanderBuilder.build();