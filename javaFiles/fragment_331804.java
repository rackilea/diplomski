Task<Void> task = new Task<Void>() {
            public Void call() throws Exception {
                int max = 200;
                for (int i = 1; i <= max; i++) {
                    updateProgress(i, max);
                    Thread.sleep(100);
                }
                System.out.println("about to close");
                return null;
            }
        };
        progressBar.progressProperty().bind(task.progressProperty());

        task.setOnSucceeded(e -> {

            exportFile();

        });

        task.setOnFailed(e -> {
            //more things
        });
        new Thread(task).start();