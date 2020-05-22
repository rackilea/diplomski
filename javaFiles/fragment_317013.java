job.addJobChangeListener(new JobChangeAdapter()
   {
     @Override
     public void done(IJobChangeEvent event)
     {
       // TODO Your work here
     }
   });

job.schedule();