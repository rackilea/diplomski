public void copyFiles(ActionEvent event) {

    executorService.execute(() -> {

        // This uses CompletableFuture.supplyAsync(Supplier, Executor)

        // need file from user
        File file = CompletableFuture.supplyAsync(() -> {
            // show FileChooser dialog and return result
        }, Platform::runLater).join(); // runs on FX thread and waits for result

        if (file == null) {
            return;
        }

        // do some stuff

        // ask for confirmation
        boolean confirmed = CompletableFuture.supplyAsync(() -> {
            // show alert and return result
        }, Platform::runLater).join(); // again, runs on FX thread and waits for result

        if (confirmed) {
            // do more stuff
        }

    });
}