private static void invoke(Task task) {
    try {
        task.perform();
    } catch (Exception e) {
        // log here    
    }
}