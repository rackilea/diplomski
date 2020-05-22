AggregationOperation project = new AggregationOperation() {
  @Override
  public DBObject toDBObject(AggregationOperationContext aggregationOperationContext) {
       return new BasicDBObject("$project", new BasicDBObject("budget_code", 1).append("task_code",  Arrays.asList("$task_code")).append("action_code", Arrays.asList("$action_code")));
     }
  };

Aggregation aggregation = newAggregation(project,
         group("budgetCode", "taskCode").addToSet("actionCode").as("actionCodes"),
         group("_id.budgetCode").addToSet(new BasicDBObject("taskCode","$_id.taskCode").append("actionCodes", "$actionCodes")).as("taskCodeActionCodes"),
            project("taskCodeActionCodes").and("budgetCodes").previousOperation().andExclude("_id"),
         sort(Sort.Direction.ASC, "budgetCodes"));