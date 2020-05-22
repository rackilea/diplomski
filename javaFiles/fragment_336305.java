ProgressManager.getInstance().run(new Task.Backgroundable(project, "Title"){
        public void run(@NotNull ProgressIndicator progressIndicator) {

            // start your process

            // Set the progress bar percentage and text
            progressIndicator.setFraction(0.10);
            progressIndicator.setText("90% to finish");


            // 50% done
            progressIndicator.setFraction(0.50);
            progressIndicator.setText("50% to finish");


            // Finished
            progressIndicator.setFraction(1.0);
            progressIndicator.setText("finished");

        }});