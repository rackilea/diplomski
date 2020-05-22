public enum OrderStatus
{
    ACTIVE("A","Active Order"),
    AWAITING("I","Awaiting Order");

    private String shortName;
    private String description;

    private OrderStatus(String shortName, String description)
    {
        this.shortName = shortName;
        this.description = description;
    }

    public String getShortName()
    {
        return shortName;
    }

    public String getDescription()
    {
        return description;
    }   
}