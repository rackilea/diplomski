Job job = new MyPluginJob("Update info", "Your_plugin_job_family_name")
        {
            @Override
            protected IStatus run(IProgressMonitor monitor)
            {
                //do whatever you want
                return Status.OK_STATUS;
            }
        };
job.schedule();