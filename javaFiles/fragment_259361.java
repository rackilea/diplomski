public class FolioPropertiesFND
{
    private String initiative;
    private String strategy;
    ... one field per property.

    public String getInitiative()
    {
        return initiative;
    }

    public void setInitiative(final String newValue)
    {
        initiative = newValue;
    }
}