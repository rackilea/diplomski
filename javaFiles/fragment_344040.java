ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    service.schedule(() -> {
        //do something

        Platform.runLater(() -> {
            //do something with ui
        });
    }, 5, TimeUnit.SECONDS);