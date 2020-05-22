startThinking() {     
        new SwingWorker<Void, Void>() {
                @Override
                public Void doInBackground() {
                    // do your work here

                    return null;
                }
        }.execute();
    }