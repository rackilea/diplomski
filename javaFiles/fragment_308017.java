@Named
@RequestScoped
public class SomeOtherBean
{
    @Inject
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