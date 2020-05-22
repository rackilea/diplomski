public void setup(Context context)
{
    JobClient jobClient;
    RunningJob runningJob;

    try 
    {
        jobClient = new JobClient((JobConf)context.getConfiguration());
        runningJob = jobClient.getJob((JobID)(context.getJobId()); //mapred.JobID!
    }
    catch (IOException e)
    {
        System.out.println("IO Exception");
    }


    try
    {
        System.out.println(propertyName);
        session = FindPath.createSession("localhost",3250, EncodingConstants.en_ISO_8859_1);
        session.open();
    }
    catch 
    {
        System.out.println("error");
        runningJob.killTask((TaskAttemptID)context.getTaskAttemptID(), true);// cast as mapred.TaskAttemptID
    }

}