//make progress indicator visible
        pi.setVisible(true);

        // separate non-FX thread
        final ExtractorThread t = new ExtractorThread();
        t.setCp(cp);
        t.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            public void handle(WorkerStateEvent event) {
               DbExtractor dbExtractor = t.getValue();
               this.caster.goToDataSource(c, cp, dbe);
            }
        });
        t.setOnFailed(...); // similarly, to handle exceptions
        new Thread(t).start();