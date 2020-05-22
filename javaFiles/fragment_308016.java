@Named
@SessionScoped
public class Settings
{
    private boolean saveAccepted = false;

    public boolean isSaveAccepted()
    {
        return saveAccepted;
    }

    public void setSaveAccepted(boolean saveAccepted)
    {
        this.saveAccepted = saveAccepted;
    }
}