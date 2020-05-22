// can't ever be an error
supplyAsync(this::someSynchronousWork)
        .thenAcceptAsync(textArea::setText, Platform::runLater);

// just want to show "Error" in text area on error
supplyAsync(this::someSynchronousWork)
        .exceptionally(error -> "ERROR")
        .thenAcceptAsync(textArea::setText, Platform::runLater);