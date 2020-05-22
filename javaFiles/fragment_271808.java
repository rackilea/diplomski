public class MyPluginJob extends Job
{
    private String jobFamily;

    public MyPluginJob(String name, String jobFamily)
    {
        super(name);
        this.jobFamily = jobFamily;
    }

    @Override
    public boolean belongsTo(Object family)
    {
        return this.jobFamily.equals(family);
    }
}