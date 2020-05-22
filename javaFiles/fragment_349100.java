public class ClarityResourceAffectationReport {

    private String budgetCode;
    private List<TaskCode> linkedTaskCodes;
}


public class TaskCode {
    private String taskCode;
    private String[] actionCode;

}

Aggregation aggregation = newAggregation(
          group("budgetCode", "taskCode").addToSet("actionCode").as("actionCode"),
          group("_id.budgetCode").addToSet(new BasicDBObject("taskCode","$_id.taskCode").append("actionCode", "$actionCode")).as("linkedTaskCodes"),
               project("linkedTaskCodes").and("budgetCode").previousOperation().andExclude("_id"),
         sort(Sort.Direction.ASC, "budgetCode"));