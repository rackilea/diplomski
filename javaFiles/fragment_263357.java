ComboBox<String> box = new ComboBox<>();
box.getItems().add("Solve for");

// Assuming generic type of Queue based on your question
Queue<Double> queue = ...; // get instance from somewhere
while (!queue.isEmpty()) {
    box.getItems().add(queue.remove().toString());
}