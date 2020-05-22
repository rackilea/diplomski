//Find task first
QueryRequest task = new QueryRequest("Task");
task.setQueryFilter(new QueryFilter("FormattedID","=","T1234");
task.setProject("/project/12345"); //make sure searching in correct project
JsonArray taskResult = restApi.query(task).getResults().get(0).getAsJsonObject();

//Update task
JsonObject updatedValues = new JsonObject();
updatedValues.addProperty("Actuals", 5.0);
UpdateRequest taskUpdate = new UpdateRequest(task.get("_ref").getAsString(), updatedValues);
restApi.update(taskUpdate);