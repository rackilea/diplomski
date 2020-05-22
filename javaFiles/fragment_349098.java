AggregationOperation project = new AggregationOperation() {
   @Override
    public DBObject toDBObject(AggregationOperationContext aggregationOperationContext) {
         return new BasicDBObject("$project", new BasicDBObject("budget_code", 1).append("task_code",  Arrays.asList("$task_code")).append("action_code", Arrays.asList("$action_code")));
       }
    };

Aggregation aggregation = newAggregation(project,
         group("budgetCode", "taskCode").addToSet("actionCode").as("actionCodes"),
         project("actionCodes").and("_id.budgetCode").as("budgetCodes").and("_id.taskCode").as("taskCodes").andExclude("_id"),
         sort(Sort.Direction.ASC, "budgetCodes","taskCodes"));