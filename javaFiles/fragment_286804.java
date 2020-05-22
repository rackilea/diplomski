public Optional<Task> getTask(int id)  {
if(id > 0 && id <= tasks.size()) {
    for(Task task : tasks) {
        if(task.getID() == id) {
            return Optional.of(task);
        }
    }
} 

 Globals.log("Couldt find Task with ID of: " + id + " in Project: " + title); 

return Optional.empty();
}