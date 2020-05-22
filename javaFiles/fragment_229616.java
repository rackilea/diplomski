// Create a new Task and associate to the same Requirement
JsonObject newTask = new JsonObject();
newTask.addProperty("Name", "Test Task");
newTask.addProperty("State", "Defined");
newDefect.addProperty("WorkProduct", storyRef);

CreateRequest taskCreateRequest = new CreateRequest("task", newTask);
CreateResponse taskCreateResponse = restApi.create(taskCreateRequest);