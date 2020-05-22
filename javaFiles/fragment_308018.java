@ManagedBean
@RequestScoped
public class SomeOtherBean
{
    @ManagedProperty
    private Settings settings;

    public boolean getSaveAccepted()
    {
        return settings.getSaveAccepted();
    }

    public void setSaveAccepted(boolean saveAccepted)
    {
        settings.setSaveAccepted(saveAccepted);
    }
}