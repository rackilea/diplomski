Task get(Supplier<Task>... suppliers) {
    for(Supplier<Task> supplier : suppliers) {
        Task task = supplier.get();
        if(task != null) {
            return task;
        }
    }
    return new Task();
}