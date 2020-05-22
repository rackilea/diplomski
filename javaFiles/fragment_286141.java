Button button;
Task<?> task;
task.setOnSucceeded(e -> showButton(button));
task.setOnFailed(e -> showButton(button));
hideButton(button);
executor.submit(task);