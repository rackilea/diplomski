public void resetClicked(MouseEvent event) {
    event.consume();

    textArea.clear();
    CompletableFuture.supplyAsync(this::someSynchronousWork)
            .whenCompleteAsync((result, error) -> {
                if (error != null) {
                     // notify user
                } else {
                    textArea.setText(result);
                }
            }, Platform::runLater);
}