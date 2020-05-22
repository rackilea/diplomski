ProjectionOperation agg = Aggregation.project() //

      .and(new AggregationExpression() {

        @Override
        public DBObject toDbObject(AggregationOperationContext context) {

          DBObject filterExpression = new BasicDBObject();
          filterExpression.put("input", "$answer_list");
          filterExpression.put("as", "answer");
          filterExpression.put("cond", new BasicDBObject("$eq2", Arrays.<Object> asList("$$answer.question", 2)));

          return new BasicDBObject("$filter", filterExpression);
        }
      }).as("profile");