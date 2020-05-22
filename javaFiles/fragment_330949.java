for (ProjectTask task : tasks) {
    Optional<TaskEnrollmentUpdateRequest> updateTaskOptional = updatedPhase.getTasks().stream()
            .filter(t -> task.getId().equals(t.getId()) || t.getId() == null).findFirst();
    if (updateTaskOptional.isPresent()) {
        TaskEnrollmentUpdateRequest updateTask = updateTaskOptional.get();
        if (updateTask.getId() != null) {
            ...
        } else {
            ...
        }
    }
}