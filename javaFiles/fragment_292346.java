public class xyz extends Trigger<BuildableItem>
{
    @Override
    public void run()
    {       
       LOGGER.info("Project Name"+job.getName());        
    }
}