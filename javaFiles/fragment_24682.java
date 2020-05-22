AggregationOperation aggregation = new AggregationOperation() {
            @Override
            public DBObject toDBObject(AggregationOperationContext aggregationOperationContext) {
                DBObject graphLookup = new BasicDBObject(
                                "from", "relationships"). append(
                                "startWith", "$destination").append(
                                "connectFromField", "destination").append(
                                "connectToField", "source").append(
                                "maxDepth", 2).append(
                                "as", "relationshipGraph");
                return new BasicDBObject("$graphLookup", graphLookup);
            }
        };