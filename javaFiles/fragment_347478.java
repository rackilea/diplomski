JasonArray projects = myDoc.getAsJsonArray("projects");
JsonObject newProject = new JsonObject();
newProject.addProperty("_id", "project_10");
newProject.addProperty("name", "92837402937408237492837");
projects.add(newProject); //add a new entry
project.remove(0); //remove the first entry