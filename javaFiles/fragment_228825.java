Job retrieveJob = new Job("Retrieving Data") 
    {           
        @Override
        protected IStatus run(IProgressMonitor monitor) {
            // do your REST call
            ModelProvider.INSTANCE.addItems(items);
            // if something goes wrong - don't return ok, obviously 
            return Status.OK_STATUS;                
        }
    };
    retrieveJob.addJobChangeListener(new JobChangeAdapter() {

        @Override
        public void done(IJobChangeEvent event) {
            if(event.getResult().isOK())
            {
                resultLabel.setText(ModelProvider.INSTANCE.getItems().size() + " items");
                viewer.refresh();
            }
        }           
    });
    // this will run in a background thread 
    // and nicely integrate with the UI
    retrieveJob.schedule();